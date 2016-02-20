import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kev on 19/02/2016.
 */

public class GetRemoteDetails {

    //arrays to store all animals details
    private static String newId = "";
    private static String[] jumbo;
    private static String[] num;
    private static String[] sex;
    private static String[] dob;
    private static String[] name;
    private static String[] status;
    private static String[] breed;
    private static String[] dam;
    private static String[] sire;
    private static String[] replacement;
    private static String[] replacement_maternal;
    private static String[] terminal;
    private static String[] replacement_maternal_prog;
    private static String[] dairy;
    private static String[] calving_diff;
    private static String[] trait_reliability;
    // private static String[]
    public GetRemoteDetails(String usrName, String passWord) throws Exception {

        Connection.Response res = Jsoup                                 //connect to ICBF
                .connect("https://webapp.icbf.com/auth/")
                .data("username", usrName, "password", passWord)
                .method(Connection.Method.POST)
                .execute();

//This will get you cookies
        Map<String, String> loginCookies = res.cookies();

// To remain in session
        Document mainin = Jsoup.connect("https://webapp.icbf.com/profile/beef-eurostar")
                .cookies(loginCookies)
                .get();

        //System.out.println(mainin);
        String login = mainin.toString();                   //doc to strings
        String[] lines = login.split("\n");                 //splitting to lines

        int x = 0;
        // String[] words = new String[lines.length];
        ArrayList Add = new ArrayList();
        for (int i = 186; i < lines.length; i++) {
            int cc = 0;
            if (lines[i].contains(">IE")) {// && lines[i].contains("<td><a class=\"modal-link\" data-modal-width=\"895\" href=\"/profile/animal-detail/")) {
                String proper = lines[i];
                String find = proper.substring(85); //counting characters to get icbf id split
                String[] findNum = find.split("/"); //cutting off at the /
                // System.out.println(findNum[0]);     //print id's

                Add.add(findNum[0]);                //stick id's into arrayliist
                // System.out.println(Add);
            }
        }
        //set size of arrays
        jumbo = new String[Add.size()];
        num = new String[Add.size()];
        sex = new String[Add.size()];
        dob = new String[Add.size()];
        name = new String[Add.size()];
        status = new String[Add.size()];
        breed = new String[Add.size()];
        dam = new String[Add.size()];
        sire = new String[Add.size()];
        replacement = new String[Add.size()];
        replacement_maternal = new String[Add.size()];
        dairy = new String[Add.size()];
        terminal = new String[Add.size()];
        replacement_maternal_prog = new String[Add.size()];
        calving_diff = new String[Add.size()];
        trait_reliability = new String[Add.size()];

        int ju=0,nu=0, se=0, domm=0, nam=0, sta=0, bre=0, da=0, sir=0;
        for (int xx = 0; xx <2;xx++){//Add.size(); xx++) {

            newId = (String) Add.get(xx);     //take id out and make connection to individual profiles
            //System.out.print(newId);
            Document profileConnect = Jsoup.connect("https://webapp.icbf.com/profile/animal-detail/" + newId)
                    .cookies(loginCookies)
                    .get();
            // System.out.print("after socket");

            //  System.out.print(profileConnect);
            String profile = profileConnect.toString();                     //doc to strings
            String[] linesin = profile.split("\n");                         //split on newline
            String[] proper2 = new String[linesin.length];                  //array of length of lines

            for (int i = 0; i < linesin.length; i++) {                      //loop through lines
                int cc = 0;

                if (linesin[i].contains("span id=")) {                      //read lines with span id

                    proper2[cc] = linesin[i];                               //lines in array
                    //System.out.println(proper2[cc]);
                    String dataName = proper2[cc].substring(25, 28);         //parse keys
                    // System.out.print(dataName + "==");    //prints output & array name its located iin
                    switch (dataName) {
                        case "jum":                                          //get jumbo stick it in array
                            String temp0 = proper2[cc].substring(32);
                            String[] words0 = temp0.split("<");
                            jumbo[ju++] = words0[0];

                            // System.out.println(jumbo[ju - 1]);
                            break;
                        case "num":                                           //get number stick it in array
                            String temp = proper2[cc].substring(30);
                            String[] words = temp.split("<");
                            num[nu++] = words[0];
                            //System.out.println(num[nu - 1]);
                            break;
                        case "sex":                                              //get sex stick it in array
                            if (proper2[cc].contains("Female"))
                                sex[se++] = "Female";
                            else
                                sex[se++] = "Male";
                            //  System.out.println(sex[se - 1]);
                            break;
                        case "dob":                                              //get date of birth stick it in array
                            String temp2 = proper2[cc].substring(30);
                            String[] words2 = temp2.split("<");
                            dob[domm++] = words2[0];
                            //   System.out.println(dob[domm - 1]);
                            break;
                        case "nam":                                                 //get name stick it in array
                            String temp3 = proper2[cc].substring(31);
                            String[] words3 = temp3.split("<");
                            name[nam++] = words3[0];
                            //  System.out.println(name[nam - 1]);
                            break;
                        case "sta":                                                 //get days on farm stick it in array
                            String temp4 = proper2[cc].substring(33);
                            String[] words4 = temp4.split("<");
                            status[sta++] = words4[0];
                            //   System.out.println(status[sta - 1]);
                            break;
                        case "bre":                                                  //get breed stick it in array
                            String temp5 = proper2[cc].substring(32);
                            String[] words5 = temp5.split("<");
                            breed[bre++] = words5[0];
                            //   System.out.println(breed[bre - 1]);
                            break;
                        case "dam":                                                  //get mother stick it in array
                            String temp6 = proper2[cc].substring(30);
                            String[] words6 = temp6.split("<");
                            dam[da++] = words6[0];
                            //   System.out.println(dam[da - 1]);
                            break;
                        case "sir":                                                  //get father stick it in array
                            String temp7 = proper2[cc].substring(31);
                            String[] words7 = temp7.split("<");
                            sire[sir++] = words7[0];
                            //   System.out.println(sire[sir - 1]);
                            break;
                        default:
                            System.out.println("oops  :" + dataName);          //print error message
                            break;
                    }
                    cc++;
                }
            }
            //System.out.println("finished first loop");
            Document euroStarConnect = Jsoup.connect("https://webapp.icbf.com/profile/beef-animal-eurostar/" + newId)
                    .cookies(loginCookies)
                    .get();
            // System.out.print("after socket");
            //System.out.print(euroStarConnect);
            List<String> b = new ArrayList<String>();                               //create arraylist
            String profile2 = euroStarConnect.toString();                     //doc to strings
            String[] linesin2 = profile2.split("\n");                         //split on newline
            String[] diff =  new String[5];
            String[] diff3 = new String[5];
            String [] percent1 = new String[5];
            String[] percent3 = new String[5];

            String diff2 = "";
            String calv="";
            String percent= "";
            String percent2 = "";
            String []one_three = new String[10];
            for (int j = 0; j <linesin2.length ; j++) {

                if (linesin2[j].contains("<td>€")) {                        //lines that include the € sign

                    String par = linesin2[j];
                    int ll =0;
                    Pattern pattern = Pattern.compile("€(.*?)<");           //search patterns that gets value after €
                    Matcher matcher = pattern.matcher(par);                 //before <
                    while (matcher.find()) {
                        // replacement[xx] = matcher.group(1).toString();
                        ll++;
                        b.add(matcher.group(1));
                        //  System.out.println(matcher.group(1));
                    }
                }
                calv = linesin2[63];                     //searching calving
                diff = calv.split("<td>");
                diff2 = diff[1];
                diff3 = diff2.split("</");
                percent = linesin2[64];
                percent1 = percent.split("<td>");
                percent2 = percent1[1];
                percent3 = percent2.split("<s");

                //Pattern newCalv = Pattern.compile("<td>(.*?)<");
                //Matcher matcher = newCalv.matcher(calv);
                if(linesin2[j].contains("Calving difficulty")){
                    String nLine =linesin2[j++];
                    String [] aLine = nLine.split("<td>");


                }
            }
            trait_reliability[xx] = percent3[0];
            calving_diff[xx] = diff3[0];
            replacement[xx] =b.get(0);
            replacement_maternal[xx] =b.get(1);
            replacement_maternal_prog[xx] =b.get(2);
            terminal[xx]=b.get(3);
            dairy[xx]= b.get(4);
            System.out.println("rep " +  replacement[xx]);
            System.out.println("rep_mater " +replacement_maternal[xx]);
            System.out.println("rep_mater_prog " + replacement_maternal_prog[xx]);
            System.out.println("terminal "+terminal[xx]);
            System.out.println("dairy " + dairy[xx]);
            System.out.println("cal " + calving_diff[xx]);
            System.out.println("trait_rel " + trait_reliability[xx]);

        }
    }

    public JSONObject returnJSON() throws JSONException {
        JSONArray myArray = new JSONArray();
        JSONObject j = new JSONObject();

        j.put("jumbo",jumbo);
        j.put("num",num);
        j.put("sex",sex);
        j.put("dob",dob);
        j.put("name",name);
        j.put("status",status);
        j.put("breed",breed);
        j.put("dam",dam);
        j.put("sire",sire);
        j.put("replacement",replacement);
        j.put("replacement_maternal",replacement_maternal);
        j.put("terminal",terminal);
        j.put("replacement_maternal_prog",replacement_maternal_prog);
        j.put("dairy",dairy);
        j.put("calving_diff",calving_diff);
        j.put("trait_reliability",trait_reliability);

        return j;
    }


}



