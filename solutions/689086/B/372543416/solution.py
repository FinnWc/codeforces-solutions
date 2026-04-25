import sys
 
def solve():
    input = sys.stdin.readline
 
    n = int(input())
    arr = list(map(int, input().split()))
    
    six, seven = 0, 0
    for i in arr:
      if i == 6:
        six += 1
      if i == 7:
        seven += 1
    if six < 1 or seven < 1:
      print(0)
    elif six == seven:
      ans = (six * 2) - 1
      print(ans)
    elif min(six, seven) % 2 == 1:
      ans = (min(six, seven)*2)
      print(ans)
    else:
      ans = (min(six, seven))*2
      print(ans)
 
if __name__ == "__main__":
    solve()