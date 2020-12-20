package lab3.src;
import lab3.lib.*;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            int tau = 11; //Variant number
            FileReader fr = new FileReader(args[0]);
            SignalParameters sigParams;
            byte[] signalVals = fr.getBytes();
            if (signalVals == null)
            {
                System.out.println("Can not read values from file " + args[1]);
                return;
            }
            sigParams = new SignalParameters(signalVals);
            System.out.println(sigParams.valuesString(tau));
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("User did not pass a file name");
        }
        catch (Exception e)
        {
            System.out.println("Unexpected error\n" + e.getMessage());
        }
    }
}
