package lab3.lib;

//Polishuk Artem 545b

public class SignalParameters {
    private byte[] _signal;

    public SignalParameters(byte[] signal)
    {
        _signal = signal;
    }

    public byte minSignalValue()
    {
        byte minValInSignal = _signal[0];
        for(int i = 1; i < _signal.length; i++)
        {
            if(minValInSignal > _signal[i])
                minValInSignal = _signal[i];
        }
        return minValInSignal;
    }

    public byte maxSignalValue()
    {
        byte maxValInSignal = _signal[0];
        for(int i = 1; i < _signal.length; i++)
        {
            if(maxValInSignal < _signal[i])
                maxValInSignal = _signal[i];
        }
        return maxValInSignal;
    }

    public byte dynamicSignalRange()
    {
        return (byte) (maxSignalValue() - minSignalValue());
    }

    public double signalEnergy()
    {
        double res = 0;

        for (byte i:
             _signal) {
            res  = res + (Math.pow(i, 2));
        }

        return res;
    }

    public  double averageSignalPower()
    {
        return  (signalEnergy()/_signal.length);
    }

    public double signalAvgValue()
    {
        double res = 0;

        for (byte i:
                _signal) {
            res += i;
        }

        return res/_signal.length;
    }

    public double signalDispersion()
    {
        double signalAvgVal = signalAvgValue();
        double res = 0;

        for (byte i:
             _signal)
        {
            res += Math.pow((i - signalAvgVal), 2);
        }
        return res/_signal.length;
    }

    public double autocorrelationSignalFunction(int tau)
    {
        double avgSignalVal = signalAvgValue();
        double res = 0;

        if(tau < 0)
        {
            res = autocorrelationSignalFunction(0-tau);
        }
        else{
            double sum = 0;
            for(int i = 0; i < _signal.length - tau; i++)
            {
                sum += ((_signal[i+tau] - avgSignalVal)*
                        (_signal[i] - avgSignalVal));
            }
            res = sum / (_signal.length - tau);
        }
        return res;
    }

    public double signalCorelationInterval()
    {
        double result = 0;
        double numerator = 0;
        
        for(int i = 0; i < _signal.length; i++)
        {
            numerator += autocorrelationSignalFunction(i);
        }

        result = numerator / autocorrelationSignalFunction(0);

        return Math.ceil(Math.abs(result));
    }

    public String valuesString(int tau)
    {
        String strResult = "Мінімальне значення відліка в сигналі: " +  minSignalValue() + "\n" +
                        "Максимальне значення відліка в сигналі: " +  maxSignalValue() + "\n" +
                        "Динамічний діапазон сигналу: " +  dynamicSignalRange() + "\n" +
                        "Енергія сигналу: " +  signalEnergy() + "\n" +
                        "Середня потужність сигналу: " +  averageSignalPower() + "\n" +
                        "Середнє значення відліків сигналу: " +  signalAvgValue() + "\n" +
                        "Дисперсія значень відліків сигналу: " +  signalDispersion() + "\n" +
                        "Функція автокореляці дискретного сигналу (тау = " + tau + "): " +  autocorrelationSignalFunction(tau) + "\n" +
                        "Інтервал кореляції: " +  signalCorelationInterval() + "\n";
        return strResult;
    }

}
