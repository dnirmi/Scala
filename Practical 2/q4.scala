def attendance(price:Int)=120+(15-price)/5*20
def cost(price:Int)=500+3*attendance(price)
def income(price:Int)=price*attendance(price)
def profit(price:Int)=income(price)-cost(price)