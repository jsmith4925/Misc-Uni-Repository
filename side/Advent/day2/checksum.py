import pandas as pd
from collections import Counter

chars = "abcdefghijklmnopqrstuvwxyz"

twos = 0
threes = 0

with open("Advent\day2\\box_list.txt") as temp_file:
    labels = [line.strip('\n') for line in temp_file]
for i in labels:
    added_two = False
    added_three = False
    for char in chars:
        count = i.count(char)
        if count > 1:
            if count == 3 and not added_three:
                threes += 1
                added_three = True
            elif count == 2 and not added_two:
                twos += 1
                added_two = True
print(twos * threes)