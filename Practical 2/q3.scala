def normal(hour:Int)=250*hour;
def ot(hour:Double)=85*hour;
var salary= normal(hour)+ot(hour);
var tax=salary*0.12;
var takehome_salary=salary-tax;
