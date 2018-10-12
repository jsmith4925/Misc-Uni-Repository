# %% James Smith 863266 - 05/10/18
import numpy as np
import matplotlib.pyplot as plt

x = 345
w = 2
b = 5

y = (2 * x + 5)


def f(x, w, b):
    f = (w*x+b)
    print(f)


print(y)
print("Hello World")
f(x, w, b)

B = [5, 6, 7, 8]
for i in reversed(B):
    print(i)


def equals100(x):
    if x == 100:
        return True
    else:
        return False


equals100(100)

myDictionary = {
    'data_name': "myData",
    'data': np.random.randint(0, 5, (20, 3)),
    'labels': np.random.randint(0, 3, (20, 1))
}
print(myDictionary['data_name'])
print(myDictionary['data'])
print(myDictionary['labels'])


arrayOne = np.random.randint(1, 10, (2, 3))
arrayTwo = np.random.randint(1, 10, (3, 4))
result = arrayOne.dot(arrayTwo)
print(result[:, 0])

data = np.load("Iris_data.npy")
#HELP
print(data)