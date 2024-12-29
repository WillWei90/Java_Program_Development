//使用java.util套件的Scanner類別
import java.util.Scanner;

//Information類別,有三個屬性,儲存身高、體重和BMI
class Information 
{
    float height;
    float weight;
    float bmi;
}

//BMI計算class
public class BMICalculator2
{
    static Scanner ObjScanner = new Scanner(System.in);
    //輸入身高的方法try...catch
    //throws exception,交給呼叫這個方法的去處理
    public static float InputHeight() throws Exception 
    {
        System.out.print("請輸入身高(公分)：");
        try 
        {
            //Scanner物件來讀取輸入的浮點數
            float height = ObjScanner.nextFloat() / 100f;
            if(height <= 0)
            {
                throw new IllegalArgumentException("身高必須是正數");
            }
            return height;
        }
        catch(Exception e)
        {
            System.out.println("輸入錯誤：請輸入有效的數值");
            throw new Exception("無效的身高輸入", e);
        }
    }
    
    //輸入體重的方法try...catch
    //throws exception,交給呼叫這個方法的去處理
    public static float InputWeight() throws Exception
    {
        System.out.print("請輸入體重(公斤)：");
        try
        {
            float weight = ObjScanner.nextFloat();
            if(weight <= 0)
            {
                throw new IllegalArgumentException("體重必須是正數");
            }
            return weight;
        }
        catch (Exception e)
        {
            System.out.println("輸入錯誤：請輸入有效的數值");
            throw new Exception("無效的體重輸入", e);
        }
    }
    
    //計算BMI的方法
    public static float CalculateBMI(float height, float weight)
    {
        return weight / (height * height);
    }
    
    //分類的方法
    public static String BMICategory(float bmi)
    {
        if(bmi < 18.5f){return "體重過輕";} 
        else if(bmi < 24f){return "健康體位";}
        else if(bmi < 27f){return "過重";}
        else if(bmi < 30f){return "輕度肥胖";}
        else if(bmi < 35f){return "中度肥胖";}
        else{return "重度肥胖";}
    }
    
    //main function
    public static void main(String[] args)
    {
        // 建立Information物件person
        Information person = new Information();
        
        // 建立讀取輸入的 Scanner 物件, System.in :從鍵盤輸入
        Scanner myScanner = new Scanner(System.in);
        
        try 
        {
            //person的height, weight, bmi, category
            person.height = InputHeight();
            person.weight = InputWeight();
            person.bmi = CalculateBMI(person.height, person.weight);
            String category = BMICategory(person.bmi);
            
            // 顯示結果
            String bmiOutput = String.format("您的BMI值為:%.2f", person.bmi);
            System.out.println(bmiOutput);
            System.out.println("體位判定為：" + category);
        } 
        catch (Exception e) //捕捉exception並顯示訊息
        {
            System.out.println("程式發生錯誤：" + e.getMessage());
            
        } 
        finally //釋放與Scanner相關的系統資源
        {
            myScanner.close();
        }
    }
}
