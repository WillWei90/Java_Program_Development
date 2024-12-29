//�ϥ�java.util�M��Scanner���O
import java.util.Scanner;

//Information���O,���T���ݩ�,�x�s�����B�魫�MBMI
class Information 
{
    float height;
    float weight;
    float bmi;
}

//BMI�p��class
public class BMICalculator2
{
    static Scanner ObjScanner = new Scanner(System.in);
    //��J��������ktry...catch
    //throws exception,�浹�I�s�o�Ӥ�k���h�B�z
    public static float InputHeight() throws Exception 
    {
        System.out.print("�п�J����(����)�G");
        try 
        {
            //Scanner�����Ū����J���B�I��
            float height = ObjScanner.nextFloat() / 100f;
            if(height <= 0)
            {
                throw new IllegalArgumentException("���������O����");
            }
            return height;
        }
        catch(Exception e)
        {
            System.out.println("��J���~�G�п�J���Ī��ƭ�");
            throw new Exception("�L�Ī�������J", e);
        }
    }
    
    //��J�魫����ktry...catch
    //throws exception,�浹�I�s�o�Ӥ�k���h�B�z
    public static float InputWeight() throws Exception
    {
        System.out.print("�п�J�魫(����)�G");
        try
        {
            float weight = ObjScanner.nextFloat();
            if(weight <= 0)
            {
                throw new IllegalArgumentException("�魫�����O����");
            }
            return weight;
        }
        catch (Exception e)
        {
            System.out.println("��J���~�G�п�J���Ī��ƭ�");
            throw new Exception("�L�Ī��魫��J", e);
        }
    }
    
    //�p��BMI����k
    public static float CalculateBMI(float height, float weight)
    {
        return weight / (height * height);
    }
    
    //��������k
    public static String BMICategory(float bmi)
    {
        if(bmi < 18.5f){return "�魫�L��";} 
        else if(bmi < 24f){return "���d���";}
        else if(bmi < 27f){return "�L��";}
        else if(bmi < 30f){return "���תέD";}
        else if(bmi < 35f){return "���תέD";}
        else{return "���תέD";}
    }
    
    //main function
    public static void main(String[] args)
    {
        // �إ�Information����person
        Information person = new Information();
        
        // �إ�Ū����J�� Scanner ����, System.in :�q��L��J
        Scanner myScanner = new Scanner(System.in);
        
        try 
        {
            //person��height, weight, bmi, category
            person.height = InputHeight();
            person.weight = InputWeight();
            person.bmi = CalculateBMI(person.height, person.weight);
            String category = BMICategory(person.bmi);
            
            // ��ܵ��G
            String bmiOutput = String.format("�z��BMI�Ȭ�:%.2f", person.bmi);
            System.out.println(bmiOutput);
            System.out.println("���P�w���G" + category);
        } 
        catch (Exception e) //����exception����ܰT��
        {
            System.out.println("�{���o�Ϳ��~�G" + e.getMessage());
            
        } 
        finally //����PScanner�������t�θ귽
        {
            myScanner.close();
        }
    }
}
