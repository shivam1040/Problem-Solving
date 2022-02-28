class Solution:
    def numberOfCombinations(self, num: str) -> int:
        n=len(num)
        preSum=[[0]*(n+1) for _ in range(n+1)]
        for i in range(n):
            for l in range(1, i+2):
                j=i-l+1
                if num[j]=='0':
                    curr=0
                elif j==0:
                    curr=1
                else:
                    a=num[j-l:j]
                    b=num[j:i+1]
                    maxl2=0
                    if j<l:
                        maxl2=j
                    
                    elif num[j-l:j]<=num[j:i+1]:
                        a=num[j-l:j]
                        b=num[j:i+1]
                        maxl2=l
                    else:
                        maxl2=l-1
                    curr=preSum[j-1][maxl2]
                preSum[i][l]=preSum[i][l-1]+curr
        
        mod=10**9+7
        return preSum[n-1][n]%mod
obj=Solution()
print(obj.numberOfCombinations("3275"))
        