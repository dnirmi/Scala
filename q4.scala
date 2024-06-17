def discounted_price(n:Int)=24.95*n*0.6;
def shipping(n:Int)=if (n<=50) then n*3 else (n-50)*0.75+50*3;
