
def magic(target) -> bool:
    if target == [] or target == None:
        return False
    n = len(target)
    list = [i + 1 for i in range(n)]
    left = []
    right = list
    for k in range(1, n):
        left = []
        right = list
        while (True):
            if target[0:len(left)] != left:
                break
            if 0 == len(right):
                return True
            right = right[1::2] + right[0::2]
            left = left + right[0:k]
            right = right[k:]

    return False
target=[5,4,3,2,1]
print(magic(target))