import java.io.*;

/**
 * Created by Kev on 25/03/2016.
 */
public class Bull {
    public static String[] MRank;
    public static String[] MCode;
    public static String[] MBullName;
    public static String[] MBreed;
    public static String[] MIndex;
    public static String[] MRel1;
    public static String[] MStarsWithin;
    public static String[] MStarsAcross;
    public static String[] MCalvDiff;
    public static String[] MRel2;
    public static String[] MGest;
    public static String[] MRel3;
    public static String[] MDocility;
    public static String[] MRel4;
    public static String[] MCarcassWeightkgs;
    public static String[] MRel5;
    public static String[] MCarcassConf;
    public static String[] MRel6;
    public static String[] MAvail;
    public static String[] MPrice;
    public static String[] MSupplier;
    public static String[] TRank;
    public static String[] TCode;
    public static String[] TBullName;
    public static String[] TBreed;
    public static String[] TIndex;
    public static String[] TRel1;
    public static String[] TStarsWithin;
    public static String[] TStarsAcross;
    public static String[] TCalvDiff;
    public static String[] TRel2;
    public static String[] TGest;
    public static String[] TRel3;
    public static String[] TDocility;
    public static String[] TRel4;
    public static String[] TCarcassWeightkgs;
    public static String[] TRel5;
    public static String[] TCarcassConf;
    public static String[] TRel6;
    public static String[] TAvail;
    public static String[] TPrice;
    public static String[] TSupplier;



    public Bull() {
        int end = 250;
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("ActiveBeefMaternal.csv"));
//            int count = 0, ii = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                end++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        MRank = new String[end - 3];
        MCode = new String[end - 3];
        MBullName = new String[end - 3];
        MBreed = new String[end - 3];
        MIndex = new String[end - 3];
        MRel1 = new String[end - 3];
        MStarsWithin = new String[end - 3];
        MStarsAcross = new String[end - 3];
        MCalvDiff = new String[end - 3];
        MRel2 = new String[end - 3];
        MGest = new String[end - 3];
        MRel3 = new String[end - 3];
        MDocility = new String[end - 3];
        MRel4 = new String[end - 3];
        MCarcassWeightkgs = new String[end - 3];
        MRel5 = new String[end - 3];
        MCarcassConf = new String[end - 3];
        MRel6 = new String[end - 3];
        MAvail = new String[end - 3];
        MPrice = new String[end - 3];
        MSupplier = new String[end - 3];
        try {
            BufferedReader br = new BufferedReader(new FileReader("ActiveBeefMaternal.csv"));
            int count = 0, ii = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (count < 3) {
                    count++;
                } else {
                    //System.out.println(line);
                    String[] words = line.split(",");

                    MRank[ii] = words[0];
                    MCode[ii] = words[1];
                    MBullName[ii] = words[2];
                    MBreed[ii] = words[3];
                    MIndex[ii] = words[4];
                    MRel1[ii] = words[5];
                    MStarsWithin[ii] = words[6];
                    MStarsAcross[ii] = words[7];
                    MCalvDiff[ii] = words[8];
                    MRel2[ii] = words[9];
                    MGest[ii] = words[10];
                    MRel3[ii] = words[11];
                    MDocility[ii] = words[12];
                    MRel4[ii] = words[13];
                    MCarcassWeightkgs[ii] = words[14];
                    MRel5[ii] = words[15];
                    MCarcassConf[ii] = words[16];
                    MRel6[ii] = words[17];
                    MAvail[ii] = words[18];
                    MPrice[ii] = words[19];
                    MSupplier[ii] = words[20];
                    ii++;
                }
            }
            br.close();
            // line is not visible here.
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        int endt = 311;
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("ActiveBeefTerminal.csv"));
//            int count = 0, ii = 0;
//            String line;
//            while ((line = br.readLine()) != null) {
//                endt++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        TRank = new String[endt - 3];
        TCode = new String[endt - 3];
        TBullName = new String[endt - 3];
        TBreed = new String[endt - 3];
        TIndex = new String[endt - 3];
        TRel1 = new String[endt - 3];
        TStarsWithin = new String[endt - 3];
        TStarsAcross = new String[endt - 3];
        TCalvDiff = new String[endt - 3];
        TRel2 = new String[endt - 3];
        TGest = new String[endt - 3];
        TRel3 = new String[endt - 3];
        TDocility = new String[endt - 3];
        TRel4 = new String[endt - 3];
        TCarcassWeightkgs = new String[endt - 3];
        TRel5 = new String[endt - 3];
        TCarcassConf = new String[endt - 3];
        TRel6 = new String[endt - 3];
        TAvail = new String[endt - 3];
        TPrice = new String[endt - 3];
        TSupplier = new String[endt - 3];
        try {
            BufferedReader br = new BufferedReader(new FileReader("ActiveBeefTerminal.csv"));
            int count = 0, ii = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (count < 3) {
                    count++;
                } else {
                    //System.out.println(line);
                    String[] words = line.split(",");

                    TRank[ii] = words[0];
                    TCode[ii] = words[1];
                    TBullName[ii] = words[2];
                    TBreed[ii] = words[3];
                    TIndex[ii] = words[4];
                    TRel1[ii] = words[5];
                    TStarsWithin[ii] = words[6];
                    TStarsAcross[ii] = words[7];
                    TCalvDiff[ii] = words[8];
                    TRel2[ii] = words[9];
                    TGest[ii] = words[10];
                    TRel3[ii] = words[11];
                    TDocility[ii] = words[12];
                    TRel4[ii] = words[13];
                    TCarcassWeightkgs[ii] = words[14];
                    TRel5[ii] = words[15];
                    TCarcassConf[ii] = words[16];
                    TRel6[ii] = words[17];
                    TAvail[ii] = words[18];
                    TPrice[ii] = words[19];
                    TSupplier[ii] = words[20];
                    ii++;
                }
            }
            br.close();
            // line is not visible here.
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        for (int cc = 0; cc < MRank.length; cc++) {
            System.out.println(MRank[cc] + " " + MBullName[cc]);
        }
        for (int cc = 0; cc < TRank.length; cc++) {
            System.out.println(TRank[cc] + " " + TBullName[cc]);
        }


    }

}
