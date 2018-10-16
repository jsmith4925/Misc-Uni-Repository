
ALPHABET = 'abcdefghijklmnopqrstuvwxyz'


def repeat_to_length(string_to_expand, length):
    return (string_to_expand * (int(length/len(string_to_expand))+1))[:length]


def letter_to_num(letter):
    number = 0
    if letter.strip() and letter in ALPHABET:
        number = ALPHABET.index(letter)
    return number


def num_to_letter(num):
    letter = ALPHABET[num % 26]
    return letter


def vigenere_encrypt(plaintext, key):
    plaintext_nums = []
    key_nums = []
    output = []
    # print(len(plaintext)) debugging
    keystream = repeat_to_length(key, len(plaintext))
    # print(len(keystream)) debugging

    for x in plaintext:
        plaintext_nums.append(letter_to_num(x))
    for y in keystream:
        key_nums.append(letter_to_num(y))

    output_nums = [sum(x) for x in zip(plaintext_nums, key_nums)]

    # print(len(output_nums)) Debugging

    for z in output_nums:
        output.append(num_to_letter(z))

    print((''.join(output)).upper())


def main():
    p = input("Plain text: ").lower()
    k = input("Key: ").lower()
    vigenere_encrypt(p, k)


main()
