package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderPractice {
	@Test(dataProvider="getData")
	public void addProductToCart(String name,int price,int qty,String model)
	
	{
		System.out.println("The name is- "+ name+ " price- "+ price + "qty- "+  qty + "Model is- " + model);
		
	}
	@DataProvider
	public Object[][]getData(){
		
		Object[][ ]data= new Object[3][4];
		
		data[0][0]="Samsung";
		data[0][1]=10000;
		data[0][2]=20;
		data[0][3]="A80";
		
		data[1][0]="Nokia";
		data[1][1]=12000;
		data[1][2]=50;
		data[1][3]="A12";
		
		data[2][0]="Iphone";
		data[2][1]=12000;
		data[2][2]=40;
		data[2][3]="s12";
		return data;
	}

}
