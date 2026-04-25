import sys
 
def solve():
    input = sys.stdin.readline
 
    t = int(input())
    
    for _ in range(t):
      medians = [None, [1], [1, 2], [2, 1, 3]]
      ends = [None, [1], [2, 1], [3, 2, 1]]
      n = int(input())
      curr = 4
      if n < 4:
        answer(medians[n])
        continue
      
      while curr < n + 1:
        if curr % 2 == 0:
          start = int(curr / 2)
          bank = [None] + [i+1 for i in range(curr)]
          bank.remove(start)
          
          daArr = [k + 1 for k in range(curr - 1)]
          daArr.reverse()
          
          end = [bank[j] for j in daArr]
          medians.append([start] + end)
          
        else:
          start = int((curr // 2) + 1)
          bank = [None] + [i + 1 for i in range(curr)]
          bank.remove(start)
          
          end = [bank[j] for j in medians[curr - 1]]

          medians.append([start] + end)

        curr += 1

      answer(medians[n])
    
    
def answer(order):
  alphabet = [None, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
  
  ans = []
  for i in order:
    ans.append(alphabet[i])
    
  res = ''.join(ans)
  
  print(res)
  
    
 
if __name__ == "__main__":
    solve()
  