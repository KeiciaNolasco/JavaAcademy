package academiajava.exercicio05.services;

public class IncomeTaxBand {

    public static Integer getRange(Double salary) {
        if (salary <= 2112) return 1;
        else if (salary <= 2826.66) return 2;
        else if (salary <= 3751.06) return 3;
        else if (salary <= 4664.68) return 4;
        else return 5;
    }

}
