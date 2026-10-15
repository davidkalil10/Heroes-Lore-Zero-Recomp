#!/usr/bin/env python3
"""
tools/prepare_android_assets.py
Prepara a pasta android/app/src/main/assets/ para ser embutida diretamente no APK do Android.
Copia os arquivos de reference/extracted e assets/.
"""

import os
import shutil

def prepare_android_assets():
    assets_dir = os.path.join("android", "app", "src", "main", "assets")
    if os.path.exists(assets_dir):
        shutil.rmtree(assets_dir)
    os.makedirs(assets_dir, exist_ok=True)

    def ignore_rms(dir, files):
        return ["rms"] if "rms" in files else []

    # 1. Copia reference/extracted para a raiz de assets/ (exceto rms)
    if os.path.exists("reference/extracted"):
        print("[Android Assets] Copiando reference/extracted para android assets...")
        for item in os.listdir("reference/extracted"):
            if item == "rms":
                continue
            s = os.path.join("reference/extracted", item)
            d = os.path.join(assets_dir, item)
            if os.path.isdir(s):
                shutil.copytree(s, d, dirs_exist_ok=True, ignore=ignore_rms)
            else:
                shutil.copy2(s, d)

        # Também espelha para reference/extracted dentro de assets/
        print("[Android Assets] Espelhando para android assets/reference/extracted...")
        shutil.copytree("reference/extracted", os.path.join(assets_dir, "reference", "extracted"),
                        dirs_exist_ok=True, ignore=ignore_rms)

    # 2. Copia pasta assets/
    if os.path.exists("assets"):
        print("[Android Assets] Copiando pasta assets para android assets...")
        shutil.copytree("assets", assets_dir, dirs_exist_ok=True, ignore=ignore_rms)
        shutil.copytree("assets", os.path.join(assets_dir, "assets"), dirs_exist_ok=True, ignore=ignore_rms)

    print(f"[OK] Android assets preparados com sucesso em: {assets_dir}")

if __name__ == "__main__":
    prepare_android_assets()
