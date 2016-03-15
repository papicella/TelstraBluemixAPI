package ibm.com.bluemix.telstra.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by pasapicella on 15/03/2016.
 */
public class OsCommand implements Command
{
    public String execute(String command) throws Exception
    {
        StringBuffer output = new StringBuffer();

        Process p;
        try
        {
            p = Runtime.getRuntime().exec(command);

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null)
            {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }
}
