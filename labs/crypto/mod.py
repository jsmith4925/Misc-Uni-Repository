import numpy as np
MODULO = 5
def mod(x, y):
    ans = pow(x, y) % MODULO
    return ans
grid = [[0] * ((MODULO-1)) for i in range((MODULO-1))]
for x in range(MODULO-1):
    for y in range(MODULO-1):
        grid[x][y] = mod(x+1,y+1)
print(np.matrix(grid))