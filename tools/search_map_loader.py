import os

for root, dirs, files in os.walk('reference/decompiled_cfr'):
    for f in sorted(files):
        path = os.path.join(root, f)
        with open(path, 'r', encoding='utf-8', errors='ignore') as fp:
            c = fp.read()
            if '.m"' in c or '/m/' in c:
                print(f)
