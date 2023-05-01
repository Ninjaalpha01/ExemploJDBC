import re

def calc(expression: str):
    numbers = re.sub(pattern=r"[\+\-\*\/]", repl=" ", string=expression).split()
    operations = re.sub(pattern=r"[0-9\.]", repl=" ", string=expression).split()
    
    print(numbers)
    print(operations)
    
    return calcular(operations[0], float(numbers[0]), float(numbers[1]))

def calcular(operation, exp1, exp2):
    if operation == "+":
        res = exp1 + exp2
    elif operation == "-":
        res = exp1 - exp2
    elif operation == "*":
        res = exp1 * exp2
    elif operation == "/":
        res = exp1 / exp2

    return res


if __name__ == "__main__":
    result = calc(input())
    print(result)
