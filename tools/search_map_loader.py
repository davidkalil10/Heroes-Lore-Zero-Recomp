import glob

for p in glob.glob('reference/decompiled_cfr/**/*.java', recursive=True):
    with open(p, 'r', encoding='utf-8', errors='ignore') as f:
        lines = f.readlines()
    for i, l in enumerate(lines):
        if '.m"' in l or '"/m/' in l:
            print(f'{p}:{i+1}: {l.strip()}')
