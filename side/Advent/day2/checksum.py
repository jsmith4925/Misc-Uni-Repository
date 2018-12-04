import pandas as pd

with open("Advent\day2\\box_list.txt") as temp_file:
    labels = [line.strip('\n') for line in temp_file]

for line in labels[0:3]:
    print(pd.Series(line).value_counts())
     