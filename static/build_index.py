from os import listdir
from os.path import isfile, join
import json

url = 'https://raw.githubusercontent.com/nkrusch/SpaceLaunchOne/master/static/space/'
index_file = 'index.json'
dir_path = 'space'

only_files = [(url + f) for f in listdir(dir_path) if isfile(join(dir_path, f))]

img_dict = { 'images': only_files }

with open(index_file, 'w+') as outfile:
    json.dump(img_dict, outfile)
