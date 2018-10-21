import random

def roll_dice(sides):
	x = random.randint(1,sides)
	return x


def main():
	print("Welcome to Dice Roller!")
	sides = int(input("Enter Number of sides on your dice: "))
	roll = roll_dice(sides)
	print('You rolled a {0}.'.format(roll))


if __name__ == "__main__":
	#execute only if run as a script
	main()
