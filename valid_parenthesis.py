# def isValid(s):
#     stack = []
    
#     for ch in s:
#         if ch == '(' or ch == '{' or ch == '[':
#             stack.append(ch)
#         else:
#             if not stack:
#                 return False
            
#             top = stack.pop()
            
#             if ch == ')' and top != '(':
#                 return False
#             if ch == '}' and top != '{':
#                 return False
#             if ch == ']' and top != '[':
#                 return False
    
#     return len(stack) == 0

def isValid(s):
    while "()" in s or "{}" in s or "[]" in s:
        s = s.replace("()", "").replace("{}", "").replace("[]", "")
    return s == ""


def isValid(s):
    stack = []
    mapping = {')': '(', '}': '{', ']': '['}
    
    for ch in s:
        if ch in mapping:
            if not stack or stack.pop() != mapping[ch]:
                return False
        else:
            stack.append(ch)
    
    return not stack


def main():
    s = input().strip()
    result = isValid(s)
    print(result)


if __name__ == "__main__":
    main()
    