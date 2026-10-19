// natives.cpp — implementação de métodos nativos da biblioteca padrão Java (java.lang, java.util, java.io)
#include "vm.h"
#include "../platform/platform.h"
#include "../platform/updater.h"
#include "../platform/cloud_save.h"
#include "../midp/midp.h"
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <cmath>
#include <fstream>
#include <sstream>
#include <algorithm>

namespace hl {

// Helper para ler string Java
static std::u16string getStr(Object* o) {
  if (!o || o->kind != K_STRING) return u"";
  return static_cast<Str*>(o)->s;
}

static std::string getStrUtf8(Object* o) {
  return toUtf8(getStr(o));
}

// -------------------------------------------------------------
// java/lang/Object
// -------------------------------------------------------------
static void Object_init(VM&, Value*, Value*) {}

static void Object_equals(VM&, Value* args, Value* ret) {
  ret[0].i = (args[0].o == args[1].o) ? 1 : 0;
}

static void Object_getClass(VM& vm, Value* args, Value* ret) {
  if (!args[0].o) vm.npe();
  ret[0].o = vm.classObjOf(args[0].o->cls);
}

static void Object_toString(VM& vm, Value* args, Value* ret) {
  if (!args[0].o) vm.npe();
  char buf[64];
  snprintf(buf, sizeof(buf), "%s@%p", args[0].o->cls->name.c_str(), (void*)args[0].o);
  ret[0].o = vm.newStrUtf8(buf);
}

static void Object_wait(VM& vm, Value* args, Value*) {
  if (!args[0].o) vm.npe();
  int64_t ms = args[1].l;
  if (ms > 0) vm.sleepMs(ms);
}

// -------------------------------------------------------------
// java/lang/Class
// -------------------------------------------------------------
static void Class_getResourceAsStream(VM& vm, Value* args, Value* ret) {
  if (!args[0].o) vm.npe();
  Object* strObj = args[1].o;
  if (!strObj) { ret[0].o = nullptr; return; }
  std::string path = getStrUtf8(strObj);
  if (path.empty()) { ret[0].o = nullptr; return; }

  // Normaliza caminho (remove barra inicial)
  std::string relPath = path;
  if (relPath[0] == '/' || relPath[0] == '\\') relPath = relPath.substr(1);

  // Procura no diretório de dados
  std::string fullPath = vm.dataDir.empty() ? relPath : (vm.dataDir + "/" + relPath);
  std::vector<uint8_t> buf = Platform::readAsset(fullPath);
  if (buf.empty()) {
    buf = Platform::readAsset(relPath);
  }
  if (buf.empty()) {
    buf = Platform::readAsset("assets/" + relPath);
  }
  if (buf.empty()) {
    boot_log("[Asset] getResourceAsStream FALHOU: '%s' (relPath='%s')\n", path.c_str(), relPath.c_str());
    ret[0].o = nullptr;
    return;
  }
  boot_log("[Asset] getResourceAsStream OK: '%s' (%zu bytes)\n", path.c_str(), buf.size());

  ClassInfo* cbais = vm.mustClass("java/io/ByteArrayInputStream");
  Bais* bais = vm.alloc<Bais>(cbais, K_BAIS);
  bais->data = std::move(buf);
  bais->pos = 0;
  ret[0].o = bais;
}

static void Class_getName(VM& vm, Value* args, Value* ret) {
  if (!args[0].o) vm.npe();
  ClassObj* co = static_cast<ClassObj*>(args[0].o);
  std::string n = co->of ? co->of->name : "";
  for (char& c : n) if (c == '/') c = '.';
  ret[0].o = vm.newStrUtf8(n);
}

// -------------------------------------------------------------
// java/lang/String
// -------------------------------------------------------------
static void String_init(VM&, Value*, Value*) {}

static void String_init_bytes(VM& vm, Value* args, Value*) {
  Str* s = static_cast<Str*>(args[0].o);
  Array* a = static_cast<Array*>(args[1].o);
  if (!a) vm.npe();
  int off = args[2].i;
  int len = args[3].i;
  if (off < 0 || len < 0 || off + len > a->len) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  const char* p = reinterpret_cast<const char*>(a->data.data() + off);
  s->s = fromUtf8(std::string(p, len));
}

static void String_init_bytes1(VM& vm, Value* args, Value*) {
  Str* s = static_cast<Str*>(args[0].o);
  Array* a = static_cast<Array*>(args[1].o);
  if (!a) vm.npe();
  const char* p = reinterpret_cast<const char*>(a->data.data());
  s->s = fromUtf8(std::string(p, a->len));
}

static void String_init_bytes_enc(VM& vm, Value* args, Value*) {
  Str* s = static_cast<Str*>(args[0].o);
  Array* a = static_cast<Array*>(args[1].o);
  if (!a) vm.npe();
  const char* p = reinterpret_cast<const char*>(a->data.data());
  s->s = fromUtf8(std::string(p, a->len));
}

static void String_init_chars(VM& vm, Value* args, Value*) {
  Str* s = static_cast<Str*>(args[0].o);
  Array* a = static_cast<Array*>(args[1].o);
  if (!a) vm.npe();
  const char16_t* p = reinterpret_cast<const char16_t*>(a->data.data());
  s->s.assign(p, p + a->len);
}

static void String_init_chars_offset(VM& vm, Value* args, Value*) {
  Str* s = static_cast<Str*>(args[0].o);
  Array* a = static_cast<Array*>(args[1].o);
  if (!a) vm.npe();
  int off = args[2].i;
  int len = args[3].i;
  if (off < 0 || len < 0 || off + len > a->len) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  const char16_t* p = reinterpret_cast<const char16_t*>(a->data.data() + off * 2);
  s->s.assign(p, p + len);
}

static void String_init_str(VM& vm, Value* args, Value*) {
  Str* s = static_cast<Str*>(args[0].o);
  Object* o2 = args[1].o;
  if (!o2) vm.npe();
  s->s = getStr(o2);
}

static void String_charAt(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  int idx = args[1].i;
  if (idx < 0 || (size_t)idx >= s->s.size()) vm.throwNew("java/lang/StringIndexOutOfBoundsException", std::to_string(idx));
  ret[0].i = s->s[idx];
}

static void String_compareTo(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  Str* o = static_cast<Str*>(args[1].o);
  if (!s || !o) vm.npe();
  ret[0].i = s->s.compare(o->s);
}

static void String_endsWith(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  Str* suf = static_cast<Str*>(args[1].o);
  if (!s || !suf) vm.npe();
  if (suf->s.size() > s->s.size()) { ret[0].i = 0; return; }
  ret[0].i = (s->s.compare(s->s.size() - suf->s.size(), suf->s.size(), suf->s) == 0) ? 1 : 0;
}

static void String_equals(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  Object* o = args[1].o;
  if (!s) vm.npe();
  if (s == o) { ret[0].i = 1; return; }
  if (!o || o->kind != K_STRING) { ret[0].i = 0; return; }
  ret[0].i = (s->s == static_cast<Str*>(o)->s) ? 1 : 0;
}

static void String_indexOf_ch(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  char16_t c = (char16_t)args[1].i;
  auto pos = s->s.find(c);
  ret[0].i = (pos == std::u16string::npos) ? -1 : (int)pos;
}

static void String_indexOf_str(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  Str* sub = static_cast<Str*>(args[1].o);
  if (!s || !sub) vm.npe();
  auto pos = s->s.find(sub->s);
  ret[0].i = (pos == std::u16string::npos) ? -1 : (int)pos;
}

static void String_length(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  ret[0].i = (int)s->s.size();
}

static void String_replace(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  char16_t oldC = (char16_t)args[1].i;
  char16_t newC = (char16_t)args[2].i;
  std::u16string res = s->s;
  for (auto& c : res) if (c == oldC) c = newC;
  ret[0].o = vm.newStr(res);
}

static void String_startsWith(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  Str* pre = static_cast<Str*>(args[1].o);
  if (!s || !pre) vm.npe();
  if (pre->s.size() > s->s.size()) { ret[0].i = 0; return; }
  ret[0].i = (s->s.compare(0, pre->s.size(), pre->s) == 0) ? 1 : 0;
}

static void String_substring_1(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  int begin = args[1].i;
  if (begin < 0 || (size_t)begin > s->s.size()) vm.throwNew("java/lang/StringIndexOutOfBoundsException", std::to_string(begin));
  ret[0].o = vm.newStr(s->s.substr(begin));
}

static void String_substring_2(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  int begin = args[1].i;
  int end = args[2].i;
  if (begin < 0 || end < begin || (size_t)end > s->s.size()) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  ret[0].o = vm.newStr(s->s.substr(begin, end - begin));
}

static void String_toCharArray(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  Array* arr = vm.newArray('C', (int)s->s.size());
  if (!s->s.empty()) {
    std::memcpy(arr->data.data(), s->s.data(), s->s.size() * 2);
  }
  ret[0].o = arr;
}

static void String_toLowerCase(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  std::u16string res = s->s;
  for (auto& c : res) if (c >= u'A' && c <= u'Z') c = c + (u'a' - u'A');
  ret[0].o = vm.newStr(res);
}

static void String_toUpperCase(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  std::u16string res = s->s;
  for (auto& c : res) if (c >= u'a' && c <= u'z') c = c - (u'a' - u'A');
  ret[0].o = vm.newStr(res);
}

static void String_trim(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  size_t start = 0;
  while (start < s->s.size() && s->s[start] <= 0x20) start++;
  size_t end = s->s.size();
  while (end > start && s->s[end - 1] <= 0x20) end--;
  ret[0].o = vm.newStr(s->s.substr(start, end - start));
}

static void String_valueOf_chars(VM& vm, Value* args, Value* ret) {
  Array* a = static_cast<Array*>(args[0].o);
  if (!a) vm.npe();
  const char16_t* p = reinterpret_cast<const char16_t*>(a->data.data());
  ret[0].o = vm.newStr(std::u16string(p, p + a->len));
}

static void String_valueOf_int(VM& vm, Value* args, Value* ret) {
  ret[0].o = vm.newStrUtf8(std::to_string(args[0].i));
}

static void String_concat(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  Object* o2 = args[1].o;
  if (!o2) vm.npe();
  ret[0].o = vm.newStr(s->s + getStr(o2));
}

static void String_getBytes(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  std::string u8 = toUtf8(s->s);
  Array* arr = vm.newArray('B', (int)u8.size());
  if (!u8.empty()) {
    std::memcpy(arr->data.data(), u8.data(), u8.size());
  }
  ret[0].o = arr;
}

static void String_valueOf_obj(VM& vm, Value* args, Value* ret) {
  Object* o = args[0].o;
  if (!o) {
    ret[0].o = vm.newStrUtf8("null");
    return;
  }
  if (o->kind == K_STRING) {
    ret[0].o = o;
    return;
  }
  ret[0].o = vm.newStrUtf8(o->cls ? o->cls->name : "Object");
}

// -------------------------------------------------------------
// java/lang/StringBuffer
// -------------------------------------------------------------
static void StringBuffer_init(VM&, Value*, Value*) {}

static void StringBuffer_init_str(VM& vm, Value* args, Value*) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  sb->s = getStr(args[1].o);
}

static void StringBuffer_append_chars(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  Array* a = static_cast<Array*>(args[1].o);
  if (!sb) vm.npe();
  if (a) {
    const char16_t* p = reinterpret_cast<const char16_t*>(a->data.data());
    sb->s.append(p, p + a->len);
  }
  ret[0].o = sb;
}

static void StringBuffer_append_char(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  sb->s.push_back((char16_t)args[1].i);
  ret[0].o = sb;
}

static void StringBuffer_append_int(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  std::u16string num = fromUtf8(std::to_string(args[1].i));
  sb->s.append(num);
  ret[0].o = sb;
}

static void StringBuffer_append_obj(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  Object* o = args[1].o;
  if (!sb) vm.npe();
  if (!o) {
    sb->s.append(u"null");
  } else if (o->kind == K_STRING) {
    sb->s.append(static_cast<Str*>(o)->s);
  } else {
    Value vr[2];
    vm.invokeVirtual(o, "toString:()Ljava/lang/String;", nullptr, 0, vr);
    sb->s.append(getStr(vr[0].o));
  }
  ret[0].o = sb;
}

static void StringBuffer_append_str(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  Object* strObj = args[1].o;
  if (!sb) vm.npe();
  if (!strObj) sb->s.append(u"null");
  else sb->s.append(getStr(strObj));
  ret[0].o = sb;
}

static void StringBuffer_charAt(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  int idx = args[1].i;
  if (idx < 0 || (size_t)idx >= sb->s.size()) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  ret[0].i = sb->s[idx];
}

static void StringBuffer_delete(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  int start = args[1].i;
  int end = args[2].i;
  if (start < 0 || (size_t)start > sb->s.size() || start > end) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  if ((size_t)end > sb->s.size()) end = (int)sb->s.size();
  sb->s.erase(start, end - start);
  ret[0].o = sb;
}

static void StringBuffer_getChars(VM& vm, Value* args, Value*) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  int srcBegin = args[1].i;
  int srcEnd = args[2].i;
  Array* dst = static_cast<Array*>(args[3].o);
  int dstBegin = args[4].i;
  if (!dst) vm.npe();
  if (srcBegin < 0 || srcBegin > srcEnd || (size_t)srcEnd > sb->s.size()) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  int len = srcEnd - srcBegin;
  if (dstBegin < 0 || dstBegin + len > dst->len) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  std::memcpy(dst->data.data() + dstBegin * 2, sb->s.data() + srcBegin, len * 2);
}

static void StringBuffer_length(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  ret[0].i = (int)sb->s.size();
}

static void StringBuffer_setCharAt(VM& vm, Value* args, Value*) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  int idx = args[1].i;
  if (idx < 0 || (size_t)idx >= sb->s.size()) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  sb->s[idx] = (char16_t)args[2].i;
}

static void StringBuffer_toString(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  ret[0].o = vm.newStr(sb->s);
}

// -------------------------------------------------------------
// java/lang/System
// -------------------------------------------------------------
static void System_arraycopy(VM& vm, Value* args, Value*) {
  Object* srcObj = args[0].o;
  int srcPos = args[1].i;
  Object* dstObj = args[2].o;
  int dstPos = args[3].i;
  int length = args[4].i;

  if (!srcObj || !dstObj) vm.npe();
  if (srcObj->kind != K_ARRAY || dstObj->kind != K_ARRAY) vm.throwNew("java/lang/ArrayStoreException");

  Array* src = static_cast<Array*>(srcObj);
  Array* dst = static_cast<Array*>(dstObj);

  if (src->type != dst->type) vm.throwNew("java/lang/ArrayStoreException");
  if (srcPos < 0 || dstPos < 0 || length < 0 || srcPos + length > src->len || dstPos + length > dst->len) {
    vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  }

  int elemSz = arrayElemSize(src->type);
  std::memmove(dst->data.data() + dstPos * elemSz, src->data.data() + srcPos * elemSz, length * elemSz);
}

static void System_currentTimeMillis(VM&, Value*, Value* ret) {
  ret[0].l = nowMs();
}

static void System_gc(VM& vm, Value*, Value*) {
  vm.gc();
}

static void System_getProperty(VM& vm, Value* args, Value* ret) {
  std::string key = getStrUtf8(args[0].o);
  if (key == "microedition.locale") {
    ret[0].o = vm.newStrUtf8("pt-BR");
  } else if (key == "microedition.platform") {
    ret[0].o = vm.newStrUtf8("j2me");
  } else if (key == "microedition.configuration") {
    ret[0].o = vm.newStrUtf8("CLDC-1.1");
  } else if (key == "microedition.profiles") {
    ret[0].o = vm.newStrUtf8("MIDP-2.0");
  } else {
    ret[0].o = nullptr;
  }
}

// -------------------------------------------------------------
// java/lang/Math
// -------------------------------------------------------------
static void Math_abs(VM&, Value* args, Value* ret) {
  int v = args[0].i;
  ret[0].i = (v < 0) ? -v : v;
}

static void Math_min(VM&, Value* args, Value* ret) {
  int a = args[0].i;
  int b = args[1].i;
  ret[0].i = (a < b) ? a : b;
}

static void Math_max(VM&, Value* args, Value* ret) {
  int a = args[0].i;
  int b = args[1].i;
  ret[0].i = (a > b) ? a : b;
}

// -------------------------------------------------------------
// java/lang/Integer
// -------------------------------------------------------------
static void Integer_parseInt_1(VM& vm, Value* args, Value* ret) {
  std::string s = getStrUtf8(args[0].o);
  try {
    ret[0].i = std::stoi(s);
  } catch (...) {
    vm.throwNew("java/lang/NumberFormatException", s);
  }
}

static void Integer_parseInt_2(VM& vm, Value* args, Value* ret) {
  std::string s = getStrUtf8(args[0].o);
  int radix = args[1].i;
  try {
    ret[0].i = std::stoi(s, nullptr, radix);
  } catch (...) {
    vm.throwNew("java/lang/NumberFormatException", s);
  }
}

static void Integer_toString(VM& vm, Value* args, Value* ret) {
  ret[0].o = vm.newStrUtf8(std::to_string(args[0].i));
}

// -------------------------------------------------------------
// java/lang/Runtime
// -------------------------------------------------------------
static void Runtime_getRuntime(VM& vm, Value*, Value* ret) {
  static Object* rt = nullptr;
  if (!rt) {
    rt = vm.newObject(vm.mustClass("java/lang/Runtime"));
    vm.roots.push_back(rt);
  }
  ret[0].o = rt;
}

static void Runtime_gc(VM& vm, Value*, Value*) {
  vm.gc();
}

// -------------------------------------------------------------
// java/lang/Thread
// -------------------------------------------------------------
static void Thread_init(VM& vm, Value* args, Value*) {
  ThreadObj* t = static_cast<ThreadObj*>(args[0].o);
  boot_log("[Native] java/lang/Thread.<init> (ThreadObj=%p, runnable=%p)\n", t, args[1].o);
  if (!t) vm.npe();
  t->runnable = args[1].o;
}

static void Thread_sleep(VM& vm, Value* args, Value*) {
  int64_t ms = args[0].l;
  if (ms <= 0) {
    vm.sleepMs(1);
    return;
  }
  int targetFps = Platform::getTargetFps();
  if (ms > 0 && ms <= 100 && g_display && g_display->current) {
    // Sincroniza e calibra o limitador de frame interno do J2ME com a taxa de quadros alvo (30 FPS vs 15 FPS)
    if (targetFps >= 30) {
      ms = (ms + 1) / 2;
    }
    if (ms < 1) ms = 1;
  }
  vm.sleepMs(ms);
}

static void Thread_start(VM& vm, Value* args, Value*) {
  ThreadObj* t = static_cast<ThreadObj*>(args[0].o);
  boot_log("[Native] java/lang/Thread.start (ThreadObj=%p)\n", t);
  if (!t) vm.npe();
  vm.startThread(t);
}

static void Thread_yield(VM& vm, Value*, Value*) {
  vm.sleepMs(0);
}

// -------------------------------------------------------------
// java/lang/Throwable
// -------------------------------------------------------------
static void Throwable_init(VM&, Value*, Value*) {}

static void Throwable_init_msg(VM&, Value* args, Value*) {
  Object* ex = args[0].o;
  Object* msg = args[1].o;
  if (ex && ex->kind == K_INST) {
    Instance* inst = static_cast<Instance*>(ex);
    if (!inst->f.empty()) inst->f[0].o = msg;
  }
}

static void Throwable_printStackTrace(VM&, Value* args, Value*) {
  Object* ex = args[0].o;
  if (ex) {
    fprintf(stderr, "[Exception] %s\n", ex->cls->name.c_str());
  }
}

static void Throwable_toString(VM& vm, Value* args, Value* ret) {
  Object* ex = args[0].o;
  if (!ex) vm.npe();
  ret[0].o = vm.newStrUtf8(ex->cls->name);
}

// -------------------------------------------------------------
// java/util/Random
// -------------------------------------------------------------
static void Random_init(VM& vm, Value* args, Value*) {
  Rand* r = static_cast<Rand*>(args[0].o);
  if (!r) vm.npe();
  r->seed = (nowMs() ^ 0x5DEECE66DLL) & ((1LL << 48) - 1);
}

static int randNext(Rand* r, int bits) {
  r->seed = (r->seed * 0x5DEECE66DLL + 0xBLL) & ((1LL << 48) - 1);
  return (int)(r->seed >> (48 - bits));
}

static void Random_nextInt_0(VM& vm, Value* args, Value* ret) {
  Rand* r = static_cast<Rand*>(args[0].o);
  if (!r) vm.npe();
  ret[0].i = randNext(r, 32);
}

static void Random_nextInt_1(VM& vm, Value* args, Value* ret) {
  Rand* r = static_cast<Rand*>(args[0].o);
  if (!r) vm.npe();
  int n = args[1].i;
  if (n <= 0) vm.throwNew("java/lang/IllegalArgumentException", "n must be positive");
  if ((n & -n) == n) {
    ret[0].i = (int)((n * (int64_t)randNext(r, 31)) >> 31);
    return;
  }
  int bits, val;
  do {
    bits = randNext(r, 31);
    val = bits % n;
  } while (bits - val + (n - 1) < 0);
  ret[0].i = val;
}

// -------------------------------------------------------------
// java/util/Vector
// -------------------------------------------------------------
static void Vector_init(VM&, Value*, Value*) {}

static void Vector_init_cap(VM& vm, Value* args, Value*) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  int cap = args[1].i;
  if (cap < 0) vm.throwNew("java/lang/IllegalArgumentException");
  v->v.reserve(cap);
}

static void Vector_addElement(VM& vm, Value* args, Value*) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  v->v.push_back(args[1].o);
}

static void Vector_elementAt(VM& vm, Value* args, Value* ret) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  int idx = args[1].i;
  if (idx < 0 || (size_t)idx >= v->v.size()) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException", std::to_string(idx));
  ret[0].o = v->v[idx];
}

static void Vector_elements(VM& vm, Value* args, Value* ret) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  ClassInfo* cenum = vm.mustClass("java/util/VectorEnumeration");
  Enum* e = vm.alloc<Enum>(cenum, K_ENUM);
  e->vec = v;
  e->idx = 0;
  ret[0].o = e;
}

static void Vector_removeAllElements(VM& vm, Value* args, Value*) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  v->v.clear();
}

static void Vector_removeElementAt(VM& vm, Value* args, Value*) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  int idx = args[1].i;
  if (idx < 0 || (size_t)idx >= v->v.size()) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException", std::to_string(idx));
  v->v.erase(v->v.begin() + idx);
}

static void Vector_setSize(VM& vm, Value* args, Value*) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  int ns = args[1].i;
  if (ns < 0) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  v->v.resize(ns, nullptr);
}

static void Vector_size(VM& vm, Value* args, Value* ret) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  ret[0].i = (int)v->v.size();
}

static void Vector_trimToSize(VM& vm, Value* args, Value*) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  v->v.shrink_to_fit();
}

static void Vector_indexOf(VM& vm, Value* args, Value* ret) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  Object* o = args[1].o;
  int idx = -1;
  for (size_t i = 0; i < v->v.size(); i++) {
    if (v->v[i] == o) { idx = (int)i; break; }
    if (o && v->v[i] && o->kind == K_STRING && v->v[i]->kind == K_STRING) {
      if (asStr(o)->s == asStr(v->v[i])->s) { idx = (int)i; break; }
    }
  }
  ret[0].i = idx;
}

static void Vector_insertElementAt(VM& vm, Value* args, Value*) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  Object* elem = args[1].o;
  int idx = args[2].i;
  if (idx < 0 || idx > (int)v->v.size()) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException", std::to_string(idx));
  v->v.insert(v->v.begin() + idx, elem);
}

// -------------------------------------------------------------
// java/util/Hashtable
// -------------------------------------------------------------
static bool htKeyEquals(Object* a, Object* b) {
  if (a == b) return true;
  if (!a || !b) return false;
  if (a->kind == K_STRING && b->kind == K_STRING) {
    return asStr(a)->s == asStr(b)->s;
  }
  return false;
}

static void Hashtable_init(VM&, Value*, Value*) {}

static void Hashtable_containsKey(VM& vm, Value* args, Value* ret) {
  HashtableObj* ht = static_cast<HashtableObj*>(args[0].o);
  if (!ht) vm.npe();
  Object* key = args[1].o;
  for (auto& e : ht->entries) {
    if (htKeyEquals(e.key, key)) { ret[0].i = 1; return; }
  }
  ret[0].i = 0;
}

static void Hashtable_get(VM& vm, Value* args, Value* ret) {
  HashtableObj* ht = static_cast<HashtableObj*>(args[0].o);
  if (!ht) vm.npe();
  Object* key = args[1].o;
  for (auto& e : ht->entries) {
    if (htKeyEquals(e.key, key)) { ret[0].o = e.val; return; }
  }
  ret[0].o = nullptr;
}

static void Hashtable_isEmpty(VM& vm, Value* args, Value* ret) {
  HashtableObj* ht = static_cast<HashtableObj*>(args[0].o);
  if (!ht) vm.npe();
  ret[0].i = ht->entries.empty() ? 1 : 0;
}

static void Hashtable_put(VM& vm, Value* args, Value* ret) {
  HashtableObj* ht = static_cast<HashtableObj*>(args[0].o);
  if (!ht) vm.npe();
  Object* key = args[1].o;
  Object* val = args[2].o;
  if (!key || !val) vm.npe();
  for (auto& e : ht->entries) {
    if (htKeyEquals(e.key, key)) {
      Object* old = e.val;
      e.val = val;
      ret[0].o = old;
      return;
    }
  }
  ht->entries.push_back({key, val});
  ret[0].o = nullptr;
}

static void Hashtable_remove(VM& vm, Value* args, Value* ret) {
  HashtableObj* ht = static_cast<HashtableObj*>(args[0].o);
  if (!ht) vm.npe();
  Object* key = args[1].o;
  for (auto it = ht->entries.begin(); it != ht->entries.end(); ++it) {
    if (htKeyEquals(it->key, key)) {
      Object* old = it->val;
      ht->entries.erase(it);
      ret[0].o = old;
      return;
    }
  }
  ret[0].o = nullptr;
}

// -------------------------------------------------------------
// java/util/VectorEnumeration
// -------------------------------------------------------------
static void VectorEnumeration_hasMoreElements(VM& vm, Value* args, Value* ret) {
  Enum* e = static_cast<Enum*>(args[0].o);
  if (!e || !e->vec) vm.npe();
  ret[0].i = (e->idx < (int)e->vec->v.size()) ? 1 : 0;
}

static void VectorEnumeration_nextElement(VM& vm, Value* args, Value* ret) {
  Enum* e = static_cast<Enum*>(args[0].o);
  if (!e || !e->vec) vm.npe();
  if (e->idx >= (int)e->vec->v.size()) vm.throwNew("java/util/NoSuchElementException");
  ret[0].o = e->vec->v[e->idx++];
}

// -------------------------------------------------------------
// java/io/ByteArrayInputStream
// -------------------------------------------------------------
static void ByteArrayInputStream_init(VM& vm, Value* args, Value*) {
  Bais* bais = static_cast<Bais*>(args[0].o);
  Array* arr = static_cast<Array*>(args[1].o);
  if (!bais || !arr) vm.npe();
  bais->data.assign(arr->data.begin(), arr->data.end());
  bais->pos = 0;
}

static void ByteArrayInputStream_read_buf(VM& vm, Value* args, Value* ret) {
  Bais* bais = static_cast<Bais*>(args[0].o);
  Array* buf = static_cast<Array*>(args[1].o);
  int off = args[2].i;
  int len = args[3].i;
  if (!bais || !buf) vm.npe();
  if (off < 0 || len < 0 || off + len > buf->len) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  if (bais->pos >= bais->data.size()) { ret[0].i = -1; return; }
  int avail = (int)(bais->data.size() - bais->pos);
  int toRead = std::min(len, avail);
  std::memcpy(buf->data.data() + off, bais->data.data() + bais->pos, toRead);
  bais->pos += toRead;
  ret[0].i = toRead;
}

static void ByteArrayInputStream_read_byte(VM& vm, Value* args, Value* ret) {
  Bais* bais = static_cast<Bais*>(args[0].o);
  if (!bais) vm.npe();
  if (bais->pos >= bais->data.size()) { ret[0].i = -1; return; }
  ret[0].i = bais->data[bais->pos++];
}

static void ByteArrayInputStream_close(VM&, Value*, Value*) {}

// -------------------------------------------------------------
// Stream Writing Helpers
// -------------------------------------------------------------
static Baos* getUnderlyingBaos(VM& vm, Object* out) {
  if (!out) vm.npe();
  if (out->kind == K_BAOS) return static_cast<Baos*>(out);
  if (out->kind == K_DOS) return getUnderlyingBaos(vm, static_cast<Dos*>(out)->out);
  vm.fatal("getUnderlyingBaos: stream não suportado: " + out->cls->name);
  return nullptr;
}

static void streamWrite(VM& vm, Object* out, const uint8_t* bytes, size_t len) {
  Baos* b = getUnderlyingBaos(vm, out);
  if (len > 0 && bytes) {
    b->data.insert(b->data.end(), bytes, bytes + len);
  }
}

static void streamWriteByte(VM& vm, Object* out, uint8_t byte) {
  Baos* b = getUnderlyingBaos(vm, out);
  b->data.push_back(byte);
}

// -------------------------------------------------------------
// java/io/ByteArrayOutputStream
// -------------------------------------------------------------
static void ByteArrayOutputStream_init(VM&, Value*, Value*) {}

static void ByteArrayOutputStream_write_buf(VM& vm, Value* args, Value*) {
  Object* out = args[0].o;
  Array* buf = static_cast<Array*>(args[1].o);
  int off = args[2].i;
  int len = args[3].i;
  if (!out || !buf) vm.npe();
  if (off < 0 || len < 0 || off + len > buf->len) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  streamWrite(vm, out, buf->data.data() + off, (size_t)len);
}

static void ByteArrayOutputStream_write_buf1(VM& vm, Value* args, Value*) {
  Object* out = args[0].o;
  Array* buf = static_cast<Array*>(args[1].o);
  if (!out || !buf) vm.npe();
  streamWrite(vm, out, buf->data.data(), (size_t)buf->len);
}

static void ByteArrayOutputStream_write_b(VM& vm, Value* args, Value*) {
  Object* out = args[0].o;
  if (!out) vm.npe();
  streamWriteByte(vm, out, (uint8_t)args[1].i);
}

static void ByteArrayOutputStream_toByteArray(VM& vm, Value* args, Value* ret) {
  Baos* baos = getUnderlyingBaos(vm, args[0].o);
  Array* arr = vm.newArray('B', (int)baos->data.size());
  if (!baos->data.empty()) std::memcpy(arr->data.data(), baos->data.data(), baos->data.size());
  ret[0].o = arr;
}

static void ByteArrayOutputStream_reset(VM& vm, Value* args, Value*) {
  Baos* baos = getUnderlyingBaos(vm, args[0].o);
  baos->data.clear();
}

static void ByteArrayOutputStream_size(VM& vm, Value* args, Value* ret) {
  Baos* baos = getUnderlyingBaos(vm, args[0].o);
  ret[0].i = (int)baos->data.size();
}

static void ByteArrayOutputStream_close(VM&, Value*, Value*) {}
static void ByteArrayOutputStream_flush(VM&, Value*, Value*) {}

// -------------------------------------------------------------
// java/io/DataInputStream
// -------------------------------------------------------------
static void DataInputStream_init(VM& vm, Value* args, Value*) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  if (!dis) vm.npe();
  dis->in = args[1].o;
}

static Bais* getUnderlyingBais(VM& vm, Object* in) {
  if (!in) vm.npe();
  if (in->kind == K_BAIS) return static_cast<Bais*>(in);
  if (in->kind == K_DIS) return getUnderlyingBais(vm, static_cast<Dis*>(in)->in);
  vm.fatal("DataInputStream wrap de stream não suportado: " + in->cls->name);
  return nullptr;
}

static void DataInputStream_readByte(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (b->pos >= b->data.size()) vm.throwNew("java/io/EOFException");
  ret[0].i = (int8_t)b->data[b->pos++];
}

static void DataInputStream_readShort(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (b->pos + 2 > b->data.size()) vm.throwNew("java/io/EOFException");
  int b1 = b->data[b->pos++];
  int b2 = b->data[b->pos++];
  ret[0].i = (int16_t)((b1 << 8) | b2);
}

static void DataInputStream_readInt(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (b->pos + 4 > b->data.size()) vm.throwNew("java/io/EOFException");
  uint32_t v = ((uint32_t)b->data[b->pos] << 24) |
               ((uint32_t)b->data[b->pos + 1] << 16) |
               ((uint32_t)b->data[b->pos + 2] << 8) |
               ((uint32_t)b->data[b->pos + 3]);
  b->pos += 4;
  ret[0].i = (int32_t)v;
}

static void DataInputStream_readFully(VM& vm, Value* args, Value*) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Array* buf = static_cast<Array*>(args[1].o);
  if (!buf) vm.npe();
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (b->pos + buf->len > b->data.size()) vm.throwNew("java/io/EOFException");
  std::memcpy(buf->data.data(), b->data.data() + b->pos, buf->len);
  b->pos += buf->len;
}

static void DataInputStream_read_buf1(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Array* buf = static_cast<Array*>(args[1].o);
  if (!buf) vm.npe();
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (b->pos >= b->data.size()) { ret[0].i = -1; return; }
  int avail = (int)(b->data.size() - b->pos);
  int toRead = std::min(buf->len, avail);
  std::memcpy(buf->data.data(), b->data.data() + b->pos, toRead);
  b->pos += toRead;
  ret[0].i = toRead;
}

static void DataInputStream_read_buf3(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Array* buf = static_cast<Array*>(args[1].o);
  int off = args[2].i;
  int len = args[3].i;
  if (!buf) vm.npe();
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (off < 0 || len < 0 || off + len > buf->len) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  if (b->pos >= b->data.size()) { ret[0].i = -1; return; }
  int avail = (int)(b->data.size() - b->pos);
  int toRead = std::min(len, avail);
  std::memcpy(buf->data.data() + off, b->data.data() + b->pos, toRead);
  b->pos += toRead;
  ret[0].i = toRead;
}

static void DataInputStream_readUTF(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (b->pos + 2 > b->data.size()) vm.throwNew("java/io/EOFException");
  uint16_t utflen = (b->data[b->pos] << 8) | b->data[b->pos + 1];
  b->pos += 2;
  if (b->pos + utflen > b->data.size()) vm.throwNew("java/io/EOFException");
  std::string s((const char*)b->data.data() + b->pos, utflen);
  b->pos += utflen;
  ret[0].o = vm.newStrUtf8(s);
}

static void DataInputStream_reset(VM& vm, Value* args, Value*) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Bais* b = getUnderlyingBais(vm, dis->in);
  b->pos = 0;
}

static void DataInputStream_skip(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  int64_t n = args[1].l;
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (n <= 0) { ret[0].l = 0; return; }
  size_t avail = (b->pos < b->data.size()) ? (b->data.size() - b->pos) : 0;
  size_t toSkip = (size_t)std::min<int64_t>(n, avail);
  b->pos += toSkip;
  ret[0].l = (int64_t)toSkip;
}

static void DataInputStream_close(VM&, Value*, Value*) {}

static void DataInputStream_readLong(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  if (!dis) vm.npe();
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (b->pos + 8 > b->data.size()) vm.throwNew("java/io/EOFException");
  uint64_t v = 0;
  for (int i = 0; i < 8; i++) {
    v = (v << 8) | (uint64_t)b->data[b->pos++];
  }
  ret[0].l = (int64_t)v;
}

// -------------------------------------------------------------
// java/io/DataOutputStream
// -------------------------------------------------------------
static void DataOutputStream_init(VM& vm, Value* args, Value*) {
  Dos* dos = static_cast<Dos*>(args[0].o);
  if (!dos) vm.npe();
  dos->out = args[1].o;
}

static void DataOutputStream_writeByte(VM& vm, Value* args, Value*) {
  streamWriteByte(vm, args[0].o, (uint8_t)args[1].i);
}

static void DataOutputStream_writeShort(VM& vm, Value* args, Value*) {
  int v = args[1].i;
  uint8_t b[2] = { (uint8_t)(v >> 8), (uint8_t)v };
  streamWrite(vm, args[0].o, b, 2);
}

static void DataOutputStream_writeInt(VM& vm, Value* args, Value*) {
  uint32_t v = (uint32_t)args[1].i;
  uint8_t b[4] = { (uint8_t)(v >> 24), (uint8_t)(v >> 16), (uint8_t)(v >> 8), (uint8_t)v };
  streamWrite(vm, args[0].o, b, 4);
}

static void DataOutputStream_writeLong(VM& vm, Value* args, Value*) {
  uint64_t v = (uint64_t)args[1].l;
  uint8_t b[8];
  for (int i = 7; i >= 0; i--) {
    b[i] = (uint8_t)(v & 0xFF);
    v >>= 8;
  }
  streamWrite(vm, args[0].o, b, 8);
}

static void DataOutputStream_writeBoolean(VM& vm, Value* args, Value*) {
  streamWriteByte(vm, args[0].o, args[1].i ? 1 : 0);
}

static void DataOutputStream_writeChar(VM& vm, Value* args, Value*) {
  int v = args[1].i;
  uint8_t b[2] = { (uint8_t)(v >> 8), (uint8_t)v };
  streamWrite(vm, args[0].o, b, 2);
}

static void DataOutputStream_writeUTF(VM& vm, Value* args, Value*) {
  Object* strObj = args[1].o;
  if (!strObj) vm.npe();
  std::string s = toUtf8(static_cast<Str*>(strObj)->s);
  if (s.size() > 65535) vm.throwNew("java/io/UTFDataFormatException");
  uint16_t sz = (uint16_t)s.size();
  uint8_t hdr[2] = { (uint8_t)(sz >> 8), (uint8_t)sz };
  streamWrite(vm, args[0].o, hdr, 2);
  streamWrite(vm, args[0].o, (const uint8_t*)s.data(), sz);
}

static void DataOutputStream_close(VM&, Value*, Value*) {}
static void DataOutputStream_flush(VM&, Value*, Value*) {}

// -------------------------------------------------------------
// java/io/InputStream / OutputStream / PrintStream
// -------------------------------------------------------------
static void InputStream_read_b(VM& vm, Value* args, Value* ret) {
  ByteArrayInputStream_read_byte(vm, args, ret);
}

static void InputStream_read_buf1(VM& vm, Value* args, Value* ret) {
  Bais* bais = static_cast<Bais*>(args[0].o);
  Array* buf = static_cast<Array*>(args[1].o);
  Value subArgs[4];
  subArgs[0].o = bais;
  subArgs[1].o = buf;
  subArgs[2].i = 0;
  subArgs[3].i = buf ? buf->len : 0;
  ByteArrayInputStream_read_buf(vm, subArgs, ret);
}

static void InputStream_skip(VM& vm, Value* args, Value* ret) {
  Bais* b = static_cast<Bais*>(args[0].o);
  int64_t n = args[1].l;
  if (!b) vm.npe();
  if (n <= 0) { ret[0].l = 0; return; }
  size_t avail = (b->pos < b->data.size()) ? (b->data.size() - b->pos) : 0;
  size_t toSkip = (size_t)std::min<int64_t>(n, avail);
  b->pos += toSkip;
  ret[0].l = (int64_t)toSkip;
}

static void InputStream_close(VM&, Value*, Value*) {}

static void InputStream_available(VM& vm, Value* args, Value* ret) {
  if (!args[0].o) vm.npe();
  Bais* b = getUnderlyingBais(vm, args[0].o);
  ret[0].i = (b && b->pos < b->data.size()) ? (int)(b->data.size() - b->pos) : 0;
}

static void Connector_open(VM& vm, Value*, Value*) {
  vm.throwNew("java/io/IOException", "Offline mode: network/SMS disabled");
}

static void OutputStream_write_buf(VM& vm, Value* args, Value*) {
  Object* out = args[0].o;
  Array* arr = static_cast<Array*>(args[1].o);
  if (!out || !arr) vm.npe();
  streamWrite(vm, out, arr->data.data(), (size_t)arr->len);
}

static void OutputStream_write_buf3(VM& vm, Value* args, Value*) {
  Object* out = args[0].o;
  Array* buf = static_cast<Array*>(args[1].o);
  int off = args[2].i;
  int len = args[3].i;
  if (!out || !buf) vm.npe();
  if (off < 0 || len < 0 || off + len > buf->len) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  streamWrite(vm, out, buf->data.data() + off, (size_t)len);
}

static void OutputStream_write_b(VM& vm, Value* args, Value*) {
  Object* out = args[0].o;
  if (!out) vm.npe();
  streamWriteByte(vm, out, (uint8_t)args[1].i);
}

static void OutputStream_close(VM&, Value*, Value*) {}
static void OutputStream_flush(VM&, Value*, Value*) {}

static void PrintStream_println_obj(VM& vm, Value* args, Value*) {
  Object* o = args[1].o;
  if (!o) printf("null\n");
  else if (o->kind == K_STRING) printf("%s\n", getStrUtf8(o).c_str());
  else {
    Value vr[2];
    vm.invokeVirtual(o, "toString:()Ljava/lang/String;", nullptr, 0, vr);
    printf("%s\n", getStrUtf8(vr[0].o).c_str());
  }
}

static void PrintStream_println_str(VM&, Value* args, Value*) {
  printf("%s\n", getStrUtf8(args[1].o).c_str());
}

// -------------------------------------------------------------
// f (Canvas principal de Heroes Lore: Zero — suporte 240x320 e 568x320 Widescreen)
// -------------------------------------------------------------
static void f_getWidth(VM&, Value*, Value* ret) {
  ret[0].i = g_screenWidth;
}

static void f_getHeight(VM&, Value*, Value* ret) {
  ret[0].i = g_screenHeight;
}

// Forward declarations para bd e ch
static void ch_init_native(VM& vm, Value* args, Value*);
static void bd_init_native(VM& vm, Value* args, Value*);
static void bd_a_native(VM& vm, Value* args, Value* ret);
static void bd_draw_native(VM& vm, Value* args, Value*);
static void bd_cursor_native(VM& vm, Value* args, Value*);
static void rpg_a_c_native(VM& vm, Value* args, Value*);

// -------------------------------------------------------------
// Registro de todos os métodos nativos
// -------------------------------------------------------------
void VM::registerNatives() {
  auto reg = [this](const std::string& key, NativeFn fn) {
    natives[key] = fn;
  };

  // Canvas f (Heroes Lore: Zero — resolução dinâmica nativa)
  reg("f.getWidth:()I", f_getWidth);
  reg("f.getHeight:()I", f_getHeight);

  // java/lang/Object
  reg("java/lang/Object.<init>:()V", Object_init);
  reg("java/lang/Object.equals:(Ljava/lang/Object;)Z", Object_equals);
  reg("java/lang/Object.getClass:()Ljava/lang/Class;", Object_getClass);
  reg("java/lang/Object.toString:()Ljava/lang/String;", Object_toString);

  // java/lang/Class
  reg("java/lang/Class.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;", Class_getResourceAsStream);
  reg("java/lang/Class.getName:()Ljava/lang/String;", Class_getName);

  // java/lang/String
  reg("java/lang/String.<init>:()V", String_init);
  reg("java/lang/String.<init>:([B)V", String_init_bytes1);
  reg("java/lang/String.<init>:([BLjava/lang/String;)V", String_init_bytes_enc);
  reg("java/lang/String.<init>:([BII)V", String_init_bytes);
  reg("java/lang/String.<init>:([C)V", String_init_chars);
  reg("java/lang/String.<init>:([CII)V", String_init_chars_offset);
  reg("java/lang/String.<init>:(Ljava/lang/String;)V", String_init_str);
  reg("java/lang/String.charAt:(I)C", String_charAt);
  reg("java/lang/String.compareTo:(Ljava/lang/String;)I", String_compareTo);
  reg("java/lang/String.endsWith:(Ljava/lang/String;)Z", String_endsWith);
  reg("java/lang/String.equals:(Ljava/lang/Object;)Z", String_equals);
  reg("java/lang/String.indexOf:(I)I", String_indexOf_ch);
  reg("java/lang/String.indexOf:(Ljava/lang/String;)I", String_indexOf_str);
  reg("java/lang/String.length:()I", String_length);
  reg("java/lang/String.replace:(CC)Ljava/lang/String;", String_replace);
  reg("java/lang/String.startsWith:(Ljava/lang/String;)Z", String_startsWith);
  reg("java/lang/String.substring:(I)Ljava/lang/String;", String_substring_1);
  reg("java/lang/String.substring:(II)Ljava/lang/String;", String_substring_2);
  reg("java/lang/String.toCharArray:()[C", String_toCharArray);
  reg("java/lang/String.toLowerCase:()Ljava/lang/String;", String_toLowerCase);
  reg("java/lang/String.toUpperCase:()Ljava/lang/String;", String_toUpperCase);
  reg("java/lang/String.trim:()Ljava/lang/String;", String_trim);
  reg("java/lang/String.valueOf:([C)Ljava/lang/String;", String_valueOf_chars);
  reg("java/lang/String.valueOf:(I)Ljava/lang/String;", String_valueOf_int);

  // java/lang/StringBuffer
  reg("java/lang/StringBuffer.<init>:()V", StringBuffer_init);
  reg("java/lang/StringBuffer.<init>:(Ljava/lang/String;)V", StringBuffer_init_str);
  reg("java/lang/StringBuffer.append:([C)Ljava/lang/StringBuffer;", StringBuffer_append_chars);
  reg("java/lang/StringBuffer.append:(C)Ljava/lang/StringBuffer;", StringBuffer_append_char);
  reg("java/lang/StringBuffer.append:(I)Ljava/lang/StringBuffer;", StringBuffer_append_int);
  reg("java/lang/StringBuffer.append:(Ljava/lang/Object;)Ljava/lang/StringBuffer;", StringBuffer_append_obj);
  reg("java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;", StringBuffer_append_str);
  reg("java/lang/StringBuffer.charAt:(I)C", StringBuffer_charAt);
  reg("java/lang/StringBuffer.delete:(II)Ljava/lang/StringBuffer;", StringBuffer_delete);
  reg("java/lang/StringBuffer.getChars:(II[CI)V", StringBuffer_getChars);
  reg("java/lang/StringBuffer.length:()I", StringBuffer_length);
  reg("java/lang/StringBuffer.setCharAt:(IC)V", StringBuffer_setCharAt);
  reg("java/lang/StringBuffer.toString:()Ljava/lang/String;", StringBuffer_toString);

  // java/lang/System
  reg("java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V", System_arraycopy);
  reg("java/lang/System.currentTimeMillis:()J", System_currentTimeMillis);
  reg("java/lang/System.gc:()V", System_gc);
  reg("java/lang/System.getProperty:(Ljava/lang/String;)Ljava/lang/String;", System_getProperty);

  // java/lang/Math
  reg("java/lang/Math.abs:(I)I", Math_abs);
  reg("java/lang/Math.min:(II)I", Math_min);

  // java/lang/Integer
  reg("java/lang/Integer.parseInt:(Ljava/lang/String;)I", Integer_parseInt_1);
  reg("java/lang/Integer.parseInt:(Ljava/lang/String;I)I", Integer_parseInt_2);

  // java/lang/Runtime
  reg("java/lang/Runtime.getRuntime:()Ljava/lang/Runtime;", Runtime_getRuntime);
  reg("java/lang/Runtime.gc:()V", Runtime_gc);

  // java/lang/Thread
  reg("java/lang/Thread.<init>:(Ljava/lang/Runnable;)V", Thread_init);
  reg("java/lang/Thread.sleep:(J)V", Thread_sleep);
  reg("java/lang/Thread.start:()V", Thread_start);
  reg("java/lang/Thread.yield:()V", Thread_yield);

  // java/lang/Throwable
  reg("java/lang/Throwable.<init>:()V", Throwable_init);
  reg("java/lang/Throwable.<init>:(Ljava/lang/String;)V", Throwable_init_msg);
  reg("java/lang/Exception.<init>:()V", Throwable_init);
  reg("java/lang/Exception.<init>:(Ljava/lang/String;)V", Throwable_init_msg);
  reg("java/io/IOException.<init>:()V", Throwable_init);
  reg("java/io/IOException.<init>:(Ljava/lang/String;)V", Throwable_init_msg);
  reg("java/lang/RuntimeException.<init>:()V", Throwable_init);
  reg("java/lang/RuntimeException.<init>:(Ljava/lang/String;)V", Throwable_init_msg);
  reg("java/lang/Throwable.printStackTrace:()V", Throwable_printStackTrace);
  reg("java/lang/Throwable.toString:()Ljava/lang/String;", Throwable_toString);

  // java/util/Random
  reg("java/util/Random.<init>:()V", Random_init);
  reg("java/util/Random.nextInt:()I", Random_nextInt_0);
  reg("java/util/Random.nextInt:(I)I", Random_nextInt_1);

  // java/util/Vector
  reg("java/util/Vector.<init>:()V", Vector_init);
  reg("java/util/Vector.<init>:(I)V", Vector_init_cap);
  reg("java/util/Vector.addElement:(Ljava/lang/Object;)V", Vector_addElement);
  reg("java/util/Vector.elementAt:(I)Ljava/lang/Object;", Vector_elementAt);
  reg("java/util/Vector.elements:()Ljava/util/Enumeration;", Vector_elements);
  reg("java/util/Vector.removeAllElements:()V", Vector_removeAllElements);
  reg("java/util/Vector.removeElementAt:(I)V", Vector_removeElementAt);
  reg("java/util/Vector.setSize:(I)V", Vector_setSize);
  reg("java/util/Vector.size:()I", Vector_size);
  reg("java/util/Vector.trimToSize:()V", Vector_trimToSize);

  // java/util/VectorEnumeration
  reg("java/util/VectorEnumeration.hasMoreElements:()Z", VectorEnumeration_hasMoreElements);
  reg("java/util/VectorEnumeration.nextElement:()Ljava/lang/Object;", VectorEnumeration_nextElement);

  // java/io/ByteArrayInputStream
  reg("java/io/ByteArrayInputStream.<init>:([B)V", ByteArrayInputStream_init);
  reg("java/io/ByteArrayInputStream.read:([BII)I", ByteArrayInputStream_read_buf);
  reg("java/io/ByteArrayInputStream.read:()I", ByteArrayInputStream_read_byte);
  reg("java/io/ByteArrayInputStream.close:()V", ByteArrayInputStream_close);

  // java/io/ByteArrayOutputStream
  reg("java/io/ByteArrayOutputStream.<init>:()V", ByteArrayOutputStream_init);
  reg("java/io/ByteArrayOutputStream.write:([BII)V", ByteArrayOutputStream_write_buf);
  reg("java/io/ByteArrayOutputStream.write:([B)V", ByteArrayOutputStream_write_buf1);
  reg("java/io/ByteArrayOutputStream.write:(I)V", ByteArrayOutputStream_write_b);
  reg("java/io/ByteArrayOutputStream.toByteArray:()[B", ByteArrayOutputStream_toByteArray);
  reg("java/io/ByteArrayOutputStream.reset:()V", ByteArrayOutputStream_reset);
  reg("java/io/ByteArrayOutputStream.size:()I", ByteArrayOutputStream_size);
  reg("java/io/ByteArrayOutputStream.close:()V", ByteArrayOutputStream_close);
  reg("java/io/ByteArrayOutputStream.flush:()V", ByteArrayOutputStream_flush);

  // java/io/DataInputStream
  reg("java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V", DataInputStream_init);
  reg("java/io/DataInputStream.readByte:()B", DataInputStream_readByte);
  reg("java/io/DataInputStream.readShort:()S", DataInputStream_readShort);
  reg("java/io/DataInputStream.readInt:()I", DataInputStream_readInt);
  reg("java/io/DataInputStream.readFully:([B)V", DataInputStream_readFully);
  reg("java/io/DataInputStream.read:([B)I", DataInputStream_read_buf1);
  reg("java/io/DataInputStream.read:([BII)I", DataInputStream_read_buf3);
  reg("java/io/DataInputStream.readUTF:()Ljava/lang/String;", DataInputStream_readUTF);
  reg("java/io/DataInputStream.reset:()V", DataInputStream_reset);
  reg("java/io/DataInputStream.skip:(J)J", DataInputStream_skip);
  reg("java/io/DataInputStream.close:()V", DataInputStream_close);

  // java/io/DataOutputStream
  reg("java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V", DataOutputStream_init);
  reg("java/io/DataOutputStream.writeByte:(I)V", DataOutputStream_writeByte);
  reg("java/io/DataOutputStream.writeShort:(I)V", DataOutputStream_writeShort);
  reg("java/io/DataOutputStream.writeInt:(I)V", DataOutputStream_writeInt);
  reg("java/io/DataOutputStream.writeBoolean:(Z)V", DataOutputStream_writeBoolean);
  reg("java/io/DataOutputStream.writeChar:(I)V", DataOutputStream_writeChar);
  reg("java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V", DataOutputStream_writeUTF);
  reg("java/io/DataOutputStream.write:([B)V", OutputStream_write_buf);
  reg("java/io/DataOutputStream.write:([BII)V", OutputStream_write_buf3);
  reg("java/io/DataOutputStream.write:(I)V", OutputStream_write_b);
  reg("java/io/DataOutputStream.close:()V", DataOutputStream_close);
  reg("java/io/DataOutputStream.flush:()V", DataOutputStream_flush);

  // java/io/InputStream
  reg("java/io/InputStream.read:()I", InputStream_read_b);
  reg("java/io/InputStream.read:([B)I", InputStream_read_buf1);
  reg("java/io/InputStream.skip:(J)J", InputStream_skip);
  reg("java/io/InputStream.close:()V", InputStream_close);

  // java/io/OutputStream
  reg("java/io/OutputStream.write:([B)V", OutputStream_write_buf);
  reg("java/io/OutputStream.write:([BII)V", OutputStream_write_buf3);
  reg("java/io/OutputStream.write:(I)V", OutputStream_write_b);
  reg("java/io/OutputStream.close:()V", OutputStream_close);
  reg("java/io/OutputStream.flush:()V", OutputStream_flush);

  // java/io/PrintStream
  reg("java/io/PrintStream.println:(Ljava/lang/Object;)V", PrintStream_println_obj);
  reg("java/io/PrintStream.println:(Ljava/lang/String;)V", PrintStream_println_str);

  // java/lang/Object
  reg("java/lang/Object.wait:(J)V", Object_wait);

  // java/lang/String
  reg("java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;", String_concat);
  reg("java/lang/String.getBytes:()[B", String_getBytes);
  reg("java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;", String_valueOf_obj);

  // java/lang/Math
  reg("java/lang/Math.max:(II)I", Math_max);

  // java/lang/Integer
  reg("java/lang/Integer.toString:(I)Ljava/lang/String;", Integer_toString);

  // java/util/Vector
  reg("java/util/Vector.indexOf:(Ljava/lang/Object;)I", Vector_indexOf);
  reg("java/util/Vector.insertElementAt:(Ljava/lang/Object;I)V", Vector_insertElementAt);

  // java/util/Hashtable
  reg("java/util/Hashtable.<init>:()V", Hashtable_init);
  reg("java/util/Hashtable.containsKey:(Ljava/lang/Object;)Z", Hashtable_containsKey);
  reg("java/util/Hashtable.get:(Ljava/lang/Object;)Ljava/lang/Object;", Hashtable_get);
  reg("java/util/Hashtable.isEmpty:()Z", Hashtable_isEmpty);
  reg("java/util/Hashtable.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", Hashtable_put);
  reg("java/util/Hashtable.remove:(Ljava/lang/Object;)Ljava/lang/Object;", Hashtable_remove);

  // java/io/DataInputStream
  reg("java/io/DataInputStream.available:()I", InputStream_available);
  reg("java/io/DataInputStream.readLong:()J", DataInputStream_readLong);

  // java/io/DataOutputStream
  reg("java/io/DataOutputStream.writeLong:(J)V", DataOutputStream_writeLong);

  // java/io/InputStream
  reg("java/io/InputStream.available:()I", InputStream_available);

  // javax/microedition/io/Connector
  reg("javax/microedition/io/Connector.open:(Ljava/lang/String;)Ljavax/microedition/io/Connection;", Connector_open);

  // HL Zero: Tabela de Strings de UI e Textos do Jogo (ch.class)
  reg("ch.<init>:(Ljava/lang/String;)V", ch_init_native);

  // HL Zero: Menu de Opções / Configurações (bd.class) com FPS, Proporção de Tela, Cloud Save, Atualizações e Idioma
  reg("bd.<init>:(Ln;Z)V", bd_init_native);
  reg("bd.a:(II)Z", bd_a_native);
  reg("bd.a:(Lcm;)V", bd_draw_native);
  reg("bd.b:(Lcm;)V", bd_cursor_native);

  // HL Zero: Tela de Título — Logo e Versão Instalada (rpg.a.c(cm))
  reg("rpg/a.c:(Lcm;)V", rpg_a_c_native);
}

static void ch_init_native(VM& vm, Value* args, Value*) {
  Object* self = args[0].o;
  if (!self || self->kind != K_INST) return;
  Instance* inst = static_cast<Instance*>(self);

  std::string path = getStrUtf8(args[1].o);
  Platform::registerChInstance(inst, path);
  Platform::reloadSingleCh(vm, inst, path);
}

// -------------------------------------------------------------
// rpg/a.c:(Lcm;)V — Desenha o fundo do título, logo do jogo e versão instalada
// -------------------------------------------------------------
static void rpg_a_c_native(VM& vm, Value* args, Value*) {
  Object* cmObj = args[0].o;
  if (!cmObj) return;

  ClassInfo* rpgA = vm.findClass("rpg/a");
  if (!rpgA) return;

  // 1. Invoca rpg.a.a(cm, false) para desenhar o fundo e molduras
  Method* mRpgAa = vm.findMethod(rpgA, "a:(Lcm;Z)V");
  if (mRpgAa) {
    Value aArgs[2];
    aArgs[0].o = cmObj;
    aArgs[1].i = 0; // false
    Value aRet[2];
    vm.invoke(mRpgAa, aArgs, aRet);
  }

  // 2. Desenha o logo rpg.e.var_cg_e em (c, d - d / 3, 3)
  FieldInfo* fRpgAc = vm.findField(rpgA, "c:I");
  FieldInfo* fRpgAd = vm.findField(rpgA, "d:I");
  int c = (fRpgAc && fRpgAc->isStatic && fRpgAc->index >= 0 && fRpgAc->index < (int)rpgA->statics.size())
            ? rpgA->statics[fRpgAc->index].i : (g_screenWidth / 2);
  int d = (fRpgAd && fRpgAd->isStatic && fRpgAd->index >= 0 && fRpgAd->index < (int)rpgA->statics.size())
            ? rpgA->statics[fRpgAd->index].i : (g_screenHeight / 2);

  ClassInfo* rpgE = vm.findClass("rpg/e");
  FieldInfo* fVarCgE = rpgE ? vm.findField(rpgE, "e:Lcg;") : nullptr;
  Object* cgE = (fVarCgE && fVarCgE->isStatic && fVarCgE->index >= 0 && fVarCgE->index < (int)rpgE->statics.size())
                  ? rpgE->statics[fVarCgE->index].o : nullptr;

  Method* mCmSetColor = cmObj->cls ? vm.findMethod(cmObj->cls, "a:(I)V") : nullptr;
  int logoY = d - d / 3;
  if (cgE && cmObj->cls) {
    Method* mCmA = vm.findMethod(cmObj->cls, "a:(Lcg;III)V");
    if (mCmA) {
      Value lArgs[5];
      lArgs[0].o = cmObj;
      lArgs[1].o = cgE;
      lArgs[2].i = c;
      lArgs[3].i = logoY;
      lArgs[4].i = 3; // HCENTER | VCENTER
      Value lRet[2];
      vm.invoke(mCmA, lArgs, lRet);
    }

    // 3. Desenha a versão instalada do jogo (ex: "v1.0.7") logo abaixo do logo do jogo (apenas no menu de título i, não no splash bv)
    ClassInfo* bvClass = vm.findClass("bv");
    ClassInfo* fClass = vm.findClass("f");
    FieldInfo* fVarAzA = fClass ? vm.findField(fClass, "a:Laz;") : nullptr;
    Object* activeAz = (fVarAzA && fVarAzA->isStatic && fVarAzA->index >= 0 && fVarAzA->index < (int)fClass->statics.size())
                         ? fClass->statics[fVarAzA->index].o : nullptr;
    bool isBv = (activeAz && bvClass && activeAz->cls == bvClass);

    ClassInfo* acClass = vm.findClass("ac");
    Method* mAcDrawTextAlign = acClass ? vm.findMethod(acClass, "a:(Lcm;II[BII)V") : nullptr;

    if (!isBv && mAcDrawTextAlign && mCmSetColor) {
      std::string verStr = HL_VERSION_TAG;
      Array* verArr = vm.newArray('B', (int)verStr.size());
      memcpy(verArr->data.data(), verStr.data(), verStr.size());

      int verY = logoY + 47;

      // Sombra sutil preta
      Value cArgs[2];
      cArgs[0].o = cmObj;
      cArgs[1].i = 0x000000;
      Value cRet[2];
      vm.invoke(mCmSetColor, cArgs, cRet);

      Value tArgs[6];
      tArgs[0].o = cmObj;
      tArgs[1].i = c + 1;
      tArgs[2].i = verY + 1;
      tArgs[3].o = verArr;
      tArgs[4].i = 0;
      tArgs[5].i = 1; // HCENTER
      Value tRet[2];
      vm.invoke(mAcDrawTextAlign, tArgs, tRet);

      // Texto em tom dourado suave / pergaminho
      cArgs[1].i = 0xD8C8A8;
      vm.invoke(mCmSetColor, cArgs, cRet);

      tArgs[1].i = c;
      tArgs[2].i = verY;
      vm.invoke(mAcDrawTextAlign, tArgs, tRet);
    }
  }

  // 4. Restaura cor vermelha (0xFF0000) exatamente como no bytecode original
  if (mCmSetColor) {
    Value cArgs[2];
    cArgs[0].o = cmObj;
    cArgs[1].i = 0xFF0000;
    Value cRet[2];
    vm.invoke(mCmSetColor, cArgs, cRet);
  }
}

static Instance* s_activeBdMenu = nullptr;

// -------------------------------------------------------------
// bd: Menu de Configurações / Opções (Heroes Lore: Zero)
// Suporte nativo a 12 opções:
// 0..6 originais: BGM, SFX, Velocidade Texto, Brilho, Vibração, Dificuldade, Dano
// 7: FPS (15 ou 30 FPS)
// 8: Tela (Padrão, Wide ou Auto)
// 9: Nuvem (Google Drive Cloud Save)
// 10: Atualizar (OTA GitHub Releases)
// 11: Idioma (Português, English, etc.)
// -------------------------------------------------------------
static void bd_init_native(VM& vm, Value* args, Value*) {
  Object* self = args[0].o;
  if (!self || self->kind != K_INST) return;
  Instance* inst = static_cast<Instance*>(self);
  s_activeBdMenu = inst;
  Object* parent = args[1].o;
  bool isPause = (args[2].i != 0);

  // Invoca super (l.<init>:(Ln;B)V) com 12 itens
  ClassInfo* lClass = vm.findClass("l");
  Method* mLInit = lClass ? vm.findMethod(lClass, "<init>:(Ln;B)V") : nullptr;
  if (mLInit) {
    Value lArgs[3];
    lArgs[0].o = self;
    lArgs[1].o = parent;
    lArgs[2].i = 12;
    Value lRet[2];
    vm.invoke(mLInit, lArgs, lRet);
  }

  // Define this.e = isPause
  FieldInfo* fE = vm.findField(inst->cls, "e:Z");
  if (fE && fE->index >= 0 && fE->index < (int)inst->f.size()) {
    inst->f[fE->index].i = isPause ? 1 : 0;
  }

  ClassInfo* nClass = vm.findClass("n");
  // n.var_boolean_b = true (anima cursor pulsante)
  FieldInfo* fNb = nClass ? vm.findField(nClass, "b:Z") : nullptr;
  if (fNb && fNb->index >= 0 && fNb->index < (int)inst->f.size()) {
    inst->f[fNb->index].i = 1;
  }

  // n.var_byte_b = 12 (número total de opções)
  FieldInfo* fNumItems = nClass ? vm.findField(nClass, "b:B") : nullptr;
  if (fNumItems && fNumItems->index >= 0 && fNumItems->index < (int)inst->f.size()) {
    inst->f[fNumItems->index].i = 12;
  }

  // Se pause menu, ajusta this.b_ para centralizar a janela modal de 224px
  if (isPause) {
    FieldInfo* fB_ = nClass ? vm.findField(nClass, "b_:I") : nullptr;
    if (fB_ && fB_->index >= 0 && fB_->index < (int)inst->f.size()) {
      ClassInfo* rpgA = vm.findClass("rpg/a");
      FieldInfo* fRpgAb = rpgA ? vm.findField(rpgA, "b:I") : nullptr;
      int screenH = (fRpgAb && fRpgAb->isStatic && fRpgAb->index >= 0 && fRpgAb->index < (int)rpgA->statics.size())
                    ? rpgA->statics[fRpgAb->index].i : g_screenHeight;
      inst->f[fB_->index].i = (screenH - 224) >> 1;
    }
  }
}

static void bd_a_native(VM& vm, Value* args, Value* ret) {
  Object* self = args[0].o;
  if (!self || self->kind != K_INST) { ret[0].i = 0; return; }
  Instance* inst = static_cast<Instance*>(self);
  s_activeBdMenu = inst;
  int n2 = args[1].i; // GameAction
  int n3 = args[2].i; // KeyCode

  ClassInfo* nClass = vm.findClass("n");
  FieldInfo* fNumItems = nClass ? vm.findField(nClass, "b:B") : nullptr;
  FieldInfo* fCurIndex = nClass ? vm.findField(nClass, "a:B") : nullptr;
  FieldInfo* fNeedsRepaint = nClass ? vm.findField(nClass, "a:Z") : nullptr;
  FieldInfo* fParent = nClass ? vm.findField(nClass, "a:Ln;") : nullptr;
  FieldInfo* fE = vm.findField(inst->cls, "e:Z");
  bool isPause = (fE && fE->index >= 0 && fE->index < (int)inst->f.size()) ? (inst->f[fE->index].i != 0) : false;

  if (fNumItems && fNumItems->index >= 0 && fNumItems->index < (int)inst->f.size()) {
    inst->f[fNumItems->index].i = 12;
  }
  int curH = (fCurIndex && fCurIndex->index >= 0 && fCurIndex->index < (int)inst->f.size()) ? inst->f[fCurIndex->index].i : 0;

  // 1. Invoca this.b(n2, n3) para submenu se houver
  Value subArgs[2]; subArgs[0].i = n2; subArgs[1].i = n3; Value subRet[2];
  vm.invokeVirtual(self, "b:(II)Z", subArgs, 2, subRet);
  if (subRet[0].i != 0) {
    ret[0].i = 1;
    return;
  }

  auto closeOptionsMenu = [&]() {
    s_activeBdMenu = nullptr;
    // Salva configurações no RMS
    ClassInfo* rpgC = vm.findClass("rpg/c");
    if (rpgC) {
      Method* mCInst = vm.findMethod(rpgC, "a:()Lrpg/c;");
      if (mCInst) {
        Value cInstRet[2];
        vm.invoke(mCInst, nullptr, cInstRet);
        if (cInstRet[0].o) {
          Method* mSave = vm.findMethod(rpgC, "j:()V");
          if (mSave) {
            Value sRet[2];
            vm.invokeVirtual(cInstRet[0].o, "j:()V", nullptr, 0, sRet);
          }
        }
      }
    }

    // n.var_boolean_c = false
    FieldInfo* fStaticC = nClass ? vm.findField(nClass, "c:Z") : nullptr;
    if (fStaticC && fStaticC->isStatic && fStaticC->index >= 0 && fStaticC->index < (int)nClass->statics.size()) {
      nClass->statics[fStaticC->index].i = 0;
    }

    // Retorna para o menu pai
    Object* parentObj = (fParent && fParent->index >= 0 && fParent->index < (int)inst->f.size()) ? inst->f[fParent->index].o : nullptr;
    if (parentObj && parentObj->kind == K_INST) {
      Instance* pInst = static_cast<Instance*>(parentObj);
      FieldInfo* fParentCur = vm.findField(pInst->cls, "a:B");
      if (fParentCur && fParentCur->index >= 0 && fParentCur->index < (int)pInst->f.size()) {
        pInst->f[fParentCur->index].i = isPause ? 1 : 3;
      }
      Method* mParentC = vm.findMethod(pInst->cls, "c:()V");
      if (mParentC) {
        Value cRet[2];
        vm.invokeVirtual(parentObj, "c:()V", nullptr, 0, cRet);
      }
    }
  };

  // 2. Se tecla RSK / Cancelar / Voltar (-7, Esc=27, Backspace=8, ou -7 no game action)
  if (n3 == -7 || n3 == 27 || n3 == 8 || n2 == -7) {
    closeOptionsMenu();
    ret[0].i = 1;
    return;
  }

  // 3. Se tecla de confirmação ('5' / 53, -5, Enter / 13, Space / 32, Fire / 8, ou LSK / -6)
  if (n3 == 53 || n3 == -5 || n3 == 13 || n3 == 32 || n2 == 8 || n2 == -6 || n3 == -6) {
    if (curH < 7) {
      if (curH == 0 || curH == 1 || curH == 4 || curH == 6) {
        Method* mBdC = vm.findMethod(inst->cls, "c:(B)V");
        if (mBdC) { Value cArgs[1]; cArgs[0].i = curH; Value cRet[2]; vm.invokeVirtual(self, "c:(B)V", cArgs, 1, cRet); }
      } else if (curH == 2) {
        ClassInfo* rpgC = vm.findClass("rpg/c");
        FieldInfo* fSpd = rpgC ? vm.findField(rpgC, "b:B") : nullptr;
        if (fSpd && fSpd->isStatic && fSpd->index >= 0 && fSpd->index < (int)rpgC->statics.size()) {
          rpgC->statics[fSpd->index].i = (rpgC->statics[fSpd->index].i + 1) % 4;
          Method* mSpd = vm.findMethod(rpgC, "a:(B)V");
          if (mSpd) { Value sArgs[1]; sArgs[0].i = rpgC->statics[fSpd->index].i; Value sRet[2]; vm.invoke(mSpd, sArgs, sRet); }
        }
      } else if (curH == 3) {
        ClassInfo* rpgC = vm.findClass("rpg/c");
        FieldInfo* fBr = rpgC ? vm.findField(rpgC, "c:B") : nullptr;
        if (fBr && fBr->isStatic && fBr->index >= 0 && fBr->index < (int)rpgC->statics.size()) {
          rpgC->statics[fBr->index].i = (rpgC->statics[fBr->index].i + 1) % 4;
        }
      } else if (curH == 5) {
        ClassInfo* rpgC = vm.findClass("rpg/c");
        FieldInfo* fDiff = rpgC ? vm.findField(rpgC, "d:B") : nullptr;
        if (fDiff && fDiff->isStatic && fDiff->index >= 0 && fDiff->index < (int)rpgC->statics.size()) {
          rpgC->statics[fDiff->index].i = (rpgC->statics[fDiff->index].i + 1) % 2;
        }
      }
      if (fNeedsRepaint && fNeedsRepaint->index >= 0 && fNeedsRepaint->index < (int)inst->f.size()) {
        inst->f[fNeedsRepaint->index].i = 1;
      }
      ret[0].i = 1;
      return;
    } else if (curH == 7) {
      Platform::toggleFps();
      if (fNeedsRepaint && fNeedsRepaint->index >= 0 && fNeedsRepaint->index < (int)inst->f.size()) {
        inst->f[fNeedsRepaint->index].i = 1;
      }
      ret[0].i = 1;
      return;
    } else if (curH == 8) {
      Platform::nextAspect(&vm);
      if (fNeedsRepaint && fNeedsRepaint->index >= 0 && fNeedsRepaint->index < (int)inst->f.size()) {
        inst->f[fNeedsRepaint->index].i = 1;
      }
      ret[0].i = 1;
      return;
    } else if (curH == 9) {
      Platform::openCloudSave(&vm);
      if (fNeedsRepaint && fNeedsRepaint->index >= 0 && fNeedsRepaint->index < (int)inst->f.size()) {
        inst->f[fNeedsRepaint->index].i = 1;
      }
      ret[0].i = 1;
      return;
    } else if (curH == 10) {
      Platform::checkForUpdates();
      if (fNeedsRepaint && fNeedsRepaint->index >= 0 && fNeedsRepaint->index < (int)inst->f.size()) {
        inst->f[fNeedsRepaint->index].i = 1;
      }
      ret[0].i = 1;
      return;
    } else if (curH == 11) {
      Platform::nextLanguage(&vm);
      if (fNeedsRepaint && fNeedsRepaint->index >= 0 && fNeedsRepaint->index < (int)inst->f.size()) {
        inst->f[fNeedsRepaint->index].i = 1;
      }
      ret[0].i = 1;
      return;
    }
  }

  // 4. Se tecla Esquerda ou Direita
  bool isLeft = (n3 == 52 || n2 == 2 || n3 == -3 || n2 == -3);
  bool isRight = (n3 == 54 || n2 == 5 || n3 == -4 || n2 == -4);

  if (isLeft || isRight) {
    if (curH < 7) {
      if (curH == 0 || curH == 1 || curH == 4 || curH == 6) {
        Method* mBdC = vm.findMethod(inst->cls, "c:(B)V");
        if (mBdC) { Value cArgs[1]; cArgs[0].i = curH; Value cRet[2]; vm.invokeVirtual(self, "c:(B)V", cArgs, 1, cRet); }
      } else if (curH == 2) {
        ClassInfo* rpgC = vm.findClass("rpg/c");
        FieldInfo* fSpd = rpgC ? vm.findField(rpgC, "b:B") : nullptr;
        if (fSpd && fSpd->isStatic && fSpd->index >= 0 && fSpd->index < (int)rpgC->statics.size()) {
          int curV = rpgC->statics[fSpd->index].i;
          curV = isLeft ? ((curV + 3) % 4) : ((curV + 1) % 4);
          rpgC->statics[fSpd->index].i = curV;
          Method* mSpd = vm.findMethod(rpgC, "a:(B)V");
          if (mSpd) { Value sArgs[1]; sArgs[0].i = curV; Value sRet[2]; vm.invoke(mSpd, sArgs, sRet); }
        }
      } else if (curH == 3) {
        ClassInfo* rpgC = vm.findClass("rpg/c");
        FieldInfo* fBr = rpgC ? vm.findField(rpgC, "c:B") : nullptr;
        if (fBr && fBr->isStatic && fBr->index >= 0 && fBr->index < (int)rpgC->statics.size()) {
          int curV = rpgC->statics[fBr->index].i;
          curV = isLeft ? ((curV + 3) % 4) : ((curV + 1) % 4);
          rpgC->statics[fBr->index].i = curV;
        }
      } else if (curH == 5) {
        ClassInfo* rpgC = vm.findClass("rpg/c");
        FieldInfo* fDiff = rpgC ? vm.findField(rpgC, "d:B") : nullptr;
        if (fDiff && fDiff->isStatic && fDiff->index >= 0 && fDiff->index < (int)rpgC->statics.size()) {
          rpgC->statics[fDiff->index].i = (rpgC->statics[fDiff->index].i + 1) % 2;
        }
      }
    } else if (curH == 7) {
      Platform::toggleFps();
    } else if (curH == 8) {
      if (isLeft) Platform::prevAspect(&vm);
      else Platform::nextAspect(&vm);
    } else if (curH == 9) {
      Platform::openCloudSave(&vm);
    } else if (curH == 10) {
      Platform::checkForUpdates();
    } else if (curH == 11) {
      if (isLeft) Platform::prevLanguage(&vm);
      else Platform::nextLanguage(&vm);
    }
    if (fNeedsRepaint && fNeedsRepaint->index >= 0 && fNeedsRepaint->index < (int)inst->f.size()) {
      inst->f[fNeedsRepaint->index].i = 1;
    }
    ret[0].i = 1;
    return;
  }

  // 5. Navegação vertical direta (sobe/desce) entre as 12 opções sem depender do limitador original do Java
  bool isUp = (n3 == 50 || n2 == 1 || n3 == -1 || n2 == -1);
  bool isDown = (n3 == 56 || n2 == 6 || n3 == -2 || n2 == -2);

  if (isUp) {
    curH = (curH + 12 - 1) % 12;
    if (fCurIndex && fCurIndex->index >= 0 && fCurIndex->index < (int)inst->f.size()) {
      inst->f[fCurIndex->index].i = curH;
    }
    if (fNeedsRepaint && fNeedsRepaint->index >= 0 && fNeedsRepaint->index < (int)inst->f.size()) {
      inst->f[fNeedsRepaint->index].i = 1;
    }
    ret[0].i = 1;
    return;
  }
  if (isDown) {
    curH = (curH + 1) % 12;
    if (fCurIndex && fCurIndex->index >= 0 && fCurIndex->index < (int)inst->f.size()) {
      inst->f[fCurIndex->index].i = curH;
    }
    if (fNeedsRepaint && fNeedsRepaint->index >= 0 && fNeedsRepaint->index < (int)inst->f.size()) {
      inst->f[fNeedsRepaint->index].i = 1;
    }
    ret[0].i = 1;
    return;
  }

  ret[0].i = 0;
}

static void bd_draw_native(VM& vm, Value* args, Value*) {
  Object* self = args[0].o;
  if (!self || self->kind != K_INST) return;
  Instance* inst = static_cast<Instance*>(self);
  s_activeBdMenu = inst;

  Object* cmObj = args[1].o;
  if (!cmObj) return;

  ClassInfo* nClass = vm.findClass("n");
  FieldInfo* fCurIndex = nClass ? vm.findField(nClass, "a:B") : nullptr;
  int curH = (fCurIndex && fCurIndex->index >= 0 && fCurIndex->index < (int)inst->f.size()) ? inst->f[fCurIndex->index].i : 0;

  FieldInfo* fE = vm.findField(inst->cls, "e:Z");
  bool isPause = (fE && fE->index >= 0 && fE->index < (int)inst->f.size()) ? (inst->f[fE->index].i != 0) : false;

  ClassInfo* rpgA = vm.findClass("rpg/a");
  FieldInfo* fRpgAc = rpgA ? vm.findField(rpgA, "c:I") : nullptr;
  FieldInfo* fRpgAd = rpgA ? vm.findField(rpgA, "d:I") : nullptr;
  FieldInfo* fRpgAb = rpgA ? vm.findField(rpgA, "b:I") : nullptr;

  int centerX = (fRpgAc && fRpgAc->isStatic && fRpgAc->index >= 0 && fRpgAc->index < (int)rpgA->statics.size())
                 ? rpgA->statics[fRpgAc->index].i : (g_screenWidth / 2);
  int centerY = (fRpgAd && fRpgAd->isStatic && fRpgAd->index >= 0 && fRpgAd->index < (int)rpgA->statics.size())
                 ? rpgA->statics[fRpgAd->index].i : (g_screenHeight / 2);
  int screenH = (fRpgAb && fRpgAb->isStatic && fRpgAb->index >= 0 && fRpgAb->index < (int)rpgA->statics.size())
                 ? rpgA->statics[fRpgAb->index].i : g_screenHeight;

  ClassInfo* cmClass = cmObj->cls;
  Method* mCmSetColor = cmClass ? vm.findMethod(cmClass, "a:(I)V") : nullptr;
  Method* mCmClip = cmClass ? vm.findMethod(cmClass, "b:(IIII)V") : nullptr;
  Method* mCmFillRect = cmClass ? vm.findMethod(cmClass, "a:(IIII)V") : nullptr;
  Method* mCmDrawLine = cmClass ? vm.findMethod(cmClass, "e:(IIII)V") : nullptr;

  auto setColor = [&](int col) {
    if (mCmSetColor) { Value cArgs[2]; cArgs[0].o = cmObj; cArgs[1].i = col; Value cRet[2]; vm.invoke(mCmSetColor, cArgs, cRet); }
  };
  auto setClip = [&](int x, int y, int w, int h) {
    if (mCmClip) { Value cArgs[5]; cArgs[0].o = cmObj; cArgs[1].i = x; cArgs[2].i = y; cArgs[3].i = w; cArgs[4].i = h; Value cRet[2]; vm.invoke(mCmClip, cArgs, cRet); }
  };
  auto fillRect = [&](int x, int y, int w, int h) {
    if (mCmFillRect) { Value fArgs[5]; fArgs[0].o = cmObj; fArgs[1].i = x; fArgs[2].i = y; fArgs[3].i = w; fArgs[4].i = h; Value fRet[2]; vm.invoke(mCmFillRect, fArgs, fRet); }
  };
  auto drawLine = [&](int x1, int y1, int x2, int y2) {
    if (mCmDrawLine) { Value lArgs[5]; lArgs[0].o = cmObj; lArgs[1].i = x1; lArgs[2].i = y1; lArgs[3].i = x2; lArgs[4].i = y2; Value lRet[2]; vm.invoke(mCmDrawLine, lArgs, lRet); }
  };

  ClassInfo* acClass = vm.findClass("ac");
  Method* mAcDrawText = acClass ? vm.findMethod(acClass, "a:(Lcm;II[BI)V") : nullptr;
  Method* mAcDrawTextAlign = acClass ? vm.findMethod(acClass, "a:(Lcm;II[BII)V") : nullptr;

  auto makeByteArray = [&](const std::string& str) -> Object* {
    Array* arr = vm.newArray('B', (int)str.size());
    memcpy(arr->data.data(), str.data(), str.size());
    return arr;
  };

  auto drawText = [&](int x, int y, Object* bArr, int flag = 0) {
    if (mAcDrawText && bArr) {
      Value tArgs[5]; tArgs[0].o = cmObj; tArgs[1].i = x; tArgs[2].i = y; tArgs[3].o = bArr; tArgs[4].i = flag; Value tRet[2];
      vm.invoke(mAcDrawText, tArgs, tRet);
    }
  };

  auto drawTextAlign = [&](int x, int y, Object* bArr, int flag, int align) {
    if (mAcDrawTextAlign && bArr) {
      Value tArgs[6]; tArgs[0].o = cmObj; tArgs[1].i = x; tArgs[2].i = y; tArgs[3].o = bArr; tArgs[4].i = flag; tArgs[5].i = align; Value tRet[2];
      vm.invoke(mAcDrawTextAlign, tArgs, tRet);
    }
  };

  ClassInfo* rpgE = vm.findClass("rpg/e");
  FieldInfo* fEChB = rpgE ? vm.findField(rpgE, "b:Lch;") : nullptr;
  Object* chBObj = (fEChB && fEChB->isStatic && fEChB->index >= 0 && fEChB->index < (int)rpgE->statics.size())
                    ? rpgE->statics[fEChB->index].o : nullptr;
  ClassInfo* chClass = chBObj ? chBObj->cls : nullptr;
  Method* mChA = chClass ? vm.findMethod(chClass, "a:(I)[B") : nullptr;

  auto getGameString = [&](int idx) -> Object* {
    if (mChA && chBObj) {
      Value sArgs[2]; sArgs[0].o = chBObj; sArgs[1].i = idx; Value sRet[2];
      vm.invoke(mChA, sArgs, sRet);
      return sRet[0].o;
    }
    return nullptr;
  };

  int startY = 0;
  int titleY = 0;

  ClassInfo* rpgD = vm.findClass("rpg/d");
  FieldInfo* fDe_ = rpgD ? vm.findField(rpgD, "e_:I") : nullptr;
  int boxW = (fDe_ && fDe_->isStatic && fDe_->index >= 0 && fDe_->index < (int)rpgD->statics.size())
              ? rpgD->statics[fDe_->index].i : (g_screenWidth - 10);
  int boxX = (centerX - (boxW >> 1));
  int boxH = 224;

  if (isPause) {
    int boxY = (screenH - boxH) >> 1;
    // Moldura do popup in-game
    setClip(boxX - 2, boxY - 2, boxW + 4, boxH + 4);
    setColor(0);
    fillRect(boxX - 2, boxY - 2, boxW + 4, boxH + 4);

    setClip(boxX, boxY, boxW, boxH);
    setColor(3550755);
    fillRect(boxX, boxY, boxW, 13); // Cabeçalho
    setColor(15723216);
    drawLine(boxX, boxY + 13, boxX + boxW, boxY + 13); // Linha divisória

    // Fundo dos 11 slots
    ClassInfo* fClass = vm.findClass("rpg/f");
    FieldInfo* fFb = fClass ? vm.findField(fClass, "b:I") : nullptr;
    int slotW = (fFb && fFb->isStatic && fFb->index >= 0 && fFb->index < (int)fClass->statics.size())
                ? (fClass->statics[fFb->index].i - 2) : (boxW - 4);
    int slotX = centerX - (slotW >> 1);
    int slotY = boxY + 3 + 28;

    Method* mNc = nClass ? vm.findMethod(nClass, "c:(Lcm;IIII)V") : nullptr;
    for (int i = 0; i < 12; ++i) {
      setColor(i != curH ? 7027456 : 0x810000);
      if (mNc) {
        Value cArgs[5]; cArgs[0].o = cmObj; cArgs[1].i = slotX; cArgs[2].i = slotY; cArgs[3].i = slotW; cArgs[4].i = 14; Value cRet[2];
        vm.invoke(mNc, cArgs, cRet);
      } else {
        fillRect(slotX + 1, slotY, slotW - 2, 14);
      }
      setColor(i != curH ? 3550755 : 0x660000);
      fillRect(slotX + 1, slotY + 1, slotW - 2, 12);
      slotY += 15;
    }

    titleY = boxY - 1;
    startY = boxY + 3 + 28;
  } else {
    // Menu de Título (rpg.a.a(cm, true))
    Method* mRpgAa = rpgA ? vm.findMethod(rpgA, "a:(Lcm;Z)V") : nullptr;
    if (mRpgAa) {
      Value aArgs[2]; aArgs[0].o = cmObj; aArgs[1].i = 1; Value aRet[2];
      vm.invoke(mRpgAa, aArgs, aRet);
    }
    titleY = centerY - 105;
    startY = centerY - 80;
  }

  // Título: "CONFIGURAÇÕES" (índice 7)
  setColor(14597755);
  Object* titleStr = getGameString(7);
  if (titleStr) drawTextAlign(centerX, titleY, titleStr, 0, 1);

  // Lê campos de áudio/config de rpg.c
  ClassInfo* rpgC = vm.findClass("rpg/c");
  FieldInfo* fBgm = rpgC ? vm.findField(rpgC, "b:Z") : nullptr;
  FieldInfo* fSfx = rpgC ? vm.findField(rpgC, "c:Z") : nullptr;
  FieldInfo* fSpd = rpgC ? vm.findField(rpgC, "b:B") : nullptr;
  FieldInfo* fBr = rpgC ? vm.findField(rpgC, "c:B") : nullptr;
  FieldInfo* fVib = rpgC ? vm.findField(rpgC, "a:Z") : nullptr;
  FieldInfo* fDiff = rpgC ? vm.findField(rpgC, "d:B") : nullptr;
  FieldInfo* fDmg = rpgC ? vm.findField(rpgC, "d:Z") : nullptr;

  bool bgmVal = (fBgm && fBgm->isStatic && fBgm->index >= 0 && fBgm->index < (int)rpgC->statics.size())
                ? (rpgC->statics[fBgm->index].i != 0) : true;
  bool sfxVal = (fSfx && fSfx->isStatic && fSfx->index >= 0 && fSfx->index < (int)rpgC->statics.size())
                ? (rpgC->statics[fSfx->index].i != 0) : true;
  int spdVal = (fSpd && fSpd->isStatic && fSpd->index >= 0 && fSpd->index < (int)rpgC->statics.size())
               ? rpgC->statics[fSpd->index].i : 0;
  int brVal = (fBr && fBr->isStatic && fBr->index >= 0 && fBr->index < (int)rpgC->statics.size())
              ? rpgC->statics[fBr->index].i : 0;
  bool vibVal = (fVib && fVib->isStatic && fVib->index >= 0 && fVib->index < (int)rpgC->statics.size())
                ? (rpgC->statics[fVib->index].i != 0) : true;
  int diffVal = (fDiff && fDiff->isStatic && fDiff->index >= 0 && fDiff->index < (int)rpgC->statics.size())
                ? rpgC->statics[fDiff->index].i : 0;
  bool dmgVal = (fDmg && fDmg->isStatic && fDmg->index >= 0 && fDmg->index < (int)rpgC->statics.size())
                ? (rpgC->statics[fDmg->index].i != 0) : true;

  int labelX = centerX - 75;
  int valX = centerX + 57;

  // 1. Rótulos 0..6
  setColor(0xFFFFFF);
  for (int i = 0; i < 7; ++i) {
    Object* lbl = getGameString(16 + i);
    if (lbl) drawText(labelX, startY + 15 * i, lbl, 0);
  }

  bool isPt = (Platform::getCurrentLanguage() == "pt" || Platform::getCurrentLanguage() == "pt_br");

  // Rótulos 7..10
  Object* lblFps = makeByteArray("FPS");
  drawText(labelX, startY + 15 * 7, lblFps, 0);

  Object* lblAspect = makeByteArray(isPt ? "Tela" : "Screen");
  drawText(labelX, startY + 15 * 8, lblAspect, 0);

  Object* lblCloud = makeByteArray(isPt ? "Nuvem" : "Cloud");
  drawText(labelX, startY + 15 * 9, lblCloud, 0);

  Object* lblUpdate = makeByteArray(isPt ? "Atualizar" : "Update");
  drawText(labelX, startY + 15 * 10, lblUpdate, 0);

  Object* lblLang = makeByteArray(isPt ? "Idioma" : "Language");
  drawText(labelX, startY + 15 * 11, lblLang, 0);

  // Valores 0..6
  auto drawToggle = [&](int row, bool val) {
    setColor(curH == row ? 0xFFFFFF : 12630160);
    Object* valObj = getGameString(val ? 37 : 38);
    if (valObj) drawTextAlign(valX, startY + 15 * row + 1, valObj, 0, 1);
  };

  drawToggle(0, bgmVal);
  drawToggle(1, sfxVal);

  setColor(curH == 2 ? 0xFFFFFF : 12630160);
  Object* spdObj = getGameString(23 + spdVal);
  if (spdObj) drawTextAlign(valX, startY + 15 * 2 + 1, spdObj, 0, 1);

  setColor(curH == 3 ? 0xFFFFFF : 12630160);
  if (brVal == 0) {
    Object* offObj = getGameString(38);
    if (offObj) drawTextAlign(valX, startY + 15 * 3 + 1, offObj, 0, 1);
  } else {
    Object* brObj = makeByteArray(std::to_string(brVal));
    if (brObj) drawTextAlign(valX, startY + 15 * 3, brObj, 0, 1);
  }

  drawToggle(4, vibVal);

  setColor(curH == 5 ? 0xFFFFFF : 12630160);
  Object* diffObj = getGameString(35 + diffVal);
  if (diffObj) drawTextAlign(valX, startY + 15 * 5 + 1, diffObj, 0, 1);

  drawToggle(6, dmgVal);

  // Valores 7..11
  setColor(curH == 7 ? 0xFFFFFF : 12630160);
  std::string txtFps = (Platform::getTargetFps() == 15) ? "15" : "30";
  Object* valFps = makeByteArray(txtFps);
  drawTextAlign(valX, startY + 15 * 7, valFps, 0, 1);

  setColor(curH == 8 ? 0xFFFFFF : 12630160);
  int curAspect = Platform::getAspectMode();
  std::string txtAspect = (curAspect == 0) ? "Auto" : ((curAspect == 1) ? "Padrao" : "Wide");
  Object* valAspect = makeByteArray(txtAspect);
  drawTextAlign(valX, startY + 15 * 8, valAspect, 0, 1);

  setColor(curH == 9 ? 0xFFFFFF : 12630160);
  std::string txtCloud = CloudSave::isLoggedIn() ? "Online" : "Acessar";
  Object* valCloud = makeByteArray(txtCloud);
  drawTextAlign(valX, startY + 15 * 9, valCloud, 0, 1);

  setColor(curH == 10 ? 0xFFFFFF : 12630160);
  std::string txtUpdate = isPt ? "Checar" : "Check";
  Object* valUpdate = makeByteArray(txtUpdate);
  drawTextAlign(valX, startY + 15 * 10, valUpdate, 0, 1);

  setColor(curH == 11 ? 0xFFFFFF : 12630160);
  std::string txtLang = Platform::getLanguageDisplayName(Platform::getCurrentLanguage());
  Object* valLang = makeByteArray(txtLang);
  drawTextAlign(valX, startY + 15 * 11, valLang, 0, 1);

  // Softkeys rodapé: n.a(cm, 2)
  Method* mNaSoft = nClass ? vm.findMethod(nClass, "a:(Lcm;I)V") : nullptr;
  if (mNaSoft) {
    Value sArgs[2]; sArgs[0].o = cmObj; sArgs[1].i = 2; Value sRet[2];
    vm.invoke(mNaSoft, sArgs, sRet);
  }

  // Desenha moldura de cursor no item selecionado
  Value cArgs[2]; cArgs[0].o = self; cArgs[1].o = cmObj;
  bd_cursor_native(vm, cArgs, nullptr);
}

static void bd_cursor_native(VM& vm, Value* args, Value*) {
  Object* self = args[0].o;
  if (!self || self->kind != K_INST) return;
  Instance* inst = static_cast<Instance*>(self);

  Object* cmObj = args[1].o;
  if (!cmObj) return;

  ClassInfo* nClass = vm.findClass("n");
  FieldInfo* fCurIndex = nClass ? vm.findField(nClass, "a:B") : nullptr;
  int curH = (fCurIndex && fCurIndex->index >= 0 && fCurIndex->index < (int)inst->f.size()) ? inst->f[fCurIndex->index].i : 0;

  FieldInfo* fE = vm.findField(inst->cls, "e:Z");
  bool isPause = (fE && fE->index >= 0 && fE->index < (int)inst->f.size()) ? (inst->f[fE->index].i != 0) : false;

  ClassInfo* rpgA = vm.findClass("rpg/a");
  FieldInfo* fRpgAc = rpgA ? vm.findField(rpgA, "c:I") : nullptr;
  FieldInfo* fRpgAd = rpgA ? vm.findField(rpgA, "d:I") : nullptr;
  FieldInfo* fRpgAb = rpgA ? vm.findField(rpgA, "b:I") : nullptr;

  int centerX = (fRpgAc && fRpgAc->isStatic && fRpgAc->index >= 0 && fRpgAc->index < (int)rpgA->statics.size())
                 ? rpgA->statics[fRpgAc->index].i : (g_screenWidth / 2);
  int centerY = (fRpgAd && fRpgAd->isStatic && fRpgAd->index >= 0 && fRpgAd->index < (int)rpgA->statics.size())
                 ? rpgA->statics[fRpgAd->index].i : (g_screenHeight / 2);
  int screenH = (fRpgAb && fRpgAb->isStatic && fRpgAb->index >= 0 && fRpgAb->index < (int)rpgA->statics.size())
                 ? rpgA->statics[fRpgAb->index].i : g_screenHeight;

  int startY = 0;
  if (isPause) {
    int boxH = 224;
    int boxY = (screenH - boxH) >> 1;
    startY = boxY + 3 + 28;
  } else {
    startY = centerY - 80;
  }

  int cursorY = startY + 15 * curH;

  // n.a:(Lcm;IIIIZ)V (desenha a moldura pulsante do cursor em torno do valor selecionado)
  Method* mNaFrame = nClass ? vm.findMethod(nClass, "a:(Lcm;IIIIZ)V") : nullptr;
  if (mNaFrame) {
    Value cArgs[6];
    cArgs[0].o = cmObj;
    cArgs[1].i = centerX + 21;
    cArgs[2].i = cursorY;
    cArgs[3].i = 69;
    cArgs[4].i = 16777215;
    cArgs[5].i = 0;
    Value cRet[2];
    vm.invoke(mNaFrame, cArgs, cRet);
  }
}

bool bd_handle_mouse_click(VM& vm, int gameX, int gameY) {
  if (Platform::isModalOrCooldownActive()) return false;
  if (!s_activeBdMenu) return false;
  Instance* inst = s_activeBdMenu;
  ClassInfo* nClass = vm.findClass("n");
  FieldInfo* fCurIndex = nClass ? vm.findField(nClass, "a:B") : nullptr;
  FieldInfo* fNeedsRepaint = nClass ? vm.findField(nClass, "a:Z") : nullptr;
  FieldInfo* fE = vm.findField(inst->cls, "e:Z");
  bool isPause = (fE && fE->index >= 0 && fE->index < (int)inst->f.size()) ? (inst->f[fE->index].i != 0) : false;

  ClassInfo* rpgA = vm.findClass("rpg/a");
  FieldInfo* fRpgAc = rpgA ? vm.findField(rpgA, "c:I") : nullptr;
  FieldInfo* fRpgAd = rpgA ? vm.findField(rpgA, "d:I") : nullptr;
  FieldInfo* fRpgAb = rpgA ? vm.findField(rpgA, "b:I") : nullptr;

  int centerX = (fRpgAc && fRpgAc->isStatic && fRpgAc->index >= 0 && fRpgAc->index < (int)rpgA->statics.size())
                 ? rpgA->statics[fRpgAc->index].i : (g_screenWidth / 2);
  int centerY = (fRpgAd && fRpgAd->isStatic && fRpgAd->index >= 0 && fRpgAd->index < (int)rpgA->statics.size())
                 ? rpgA->statics[fRpgAd->index].i : (g_screenHeight / 2);
  int screenH = (fRpgAb && fRpgAb->isStatic && fRpgAb->index >= 0 && fRpgAb->index < (int)rpgA->statics.size())
                 ? rpgA->statics[fRpgAb->index].i : g_screenHeight;

  ClassInfo* rpgD = vm.findClass("rpg/d");
  FieldInfo* fDe_ = rpgD ? vm.findField(rpgD, "e_:I") : nullptr;
  int boxW = (fDe_ && fDe_->isStatic && fDe_->index >= 0 && fDe_->index < (int)rpgD->statics.size())
              ? rpgD->statics[fDe_->index].i : (g_screenWidth - 10);
  int boxX = centerX - (boxW >> 1);
  int boxH = 224;

  int startY = 0;
  if (isPause) {
    int boxY = (screenH - boxH) >> 1;
    startY = boxY + 3 + 28;
  } else {
    startY = centerY - 80;
  }

  // Permite clicar em qualquer ponto horizontal do menu (painel central ou tela)
  int minX = std::min(boxX, centerX - 100);
  int maxX = std::max(boxX + boxW, centerX + 100);

  // Verifica se o clique foi em alguma das 12 opções
  if (gameX >= minX && gameX <= maxX && gameY >= startY && gameY < startY + 15 * 12) {
    int row = (gameY - startY) / 15;
    if (row >= 0 && row < 12) {
      if (fCurIndex && fCurIndex->index >= 0 && fCurIndex->index < (int)inst->f.size()) {
        inst->f[fCurIndex->index].i = row;
      }
      if (row == 7) {
        Platform::toggleFps();
      } else if (row == 8) {
        Platform::nextAspect(&vm);
      } else if (row == 9) {
        Platform::openCloudSave(&vm);
      } else if (row == 10) {
        Platform::checkForUpdates();
      } else if (row == 11) {
        Platform::nextLanguage(&vm);
      } else {
        Value aArgs[3];
        aArgs[0].o = inst;
        aArgs[1].i = 8;  // GameAction Fire
        aArgs[2].i = 53; // KeyCode 53
        Value aRet[2];
        bd_a_native(vm, aArgs, aRet);
      }
      if (fNeedsRepaint && fNeedsRepaint->index >= 0 && fNeedsRepaint->index < (int)inst->f.size()) {
        inst->f[fNeedsRepaint->index].i = 1;
      }
      return true;
    }
  }
  return false;
}

void bd_reset_active_menu() {
  s_activeBdMenu = nullptr;
}

}  // namespace hl

