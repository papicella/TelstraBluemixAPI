package ibm.com.bluemix.telstra.rest;

import ibm.com.bluemix.telstra.commands.Command;
import ibm.com.bluemix.telstra.commands.OsCommand;
import ibm.com.bluemix.telstra.main.Constants;
import ibm.com.bluemix.telstra.main.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/apis")
public class BluemixRest
{
    @RequestMapping(method=RequestMethod.GET, value="/create/{orgName}")
    public Result createOrg(@PathVariable String orgName)
    {
        Command osCommand = new OsCommand();
        Result result = new Result();

        try
        {
            String output = osCommand.execute(String.format(Constants.CREATE_ORG, orgName));
            result.setCommandResult("SUCCESS");
            result.setResultOutput(output);

        }
        catch (Exception ex)
        {
            result.setCommandResult("FAILED");
            result.setResultOutput(ex.getMessage());
        }

        return result;
    }

    @RequestMapping(method=RequestMethod.GET, value="/delete/{orgName}")
    public Result deleteOrg(@PathVariable String orgName)
    {
        Command osCommand = new OsCommand();
        Result result = new Result();

        try
        {
            String output = osCommand.execute(String.format(Constants.DELETE_ORG, orgName));
            result.setCommandResult("SUCCESS");
            result.setResultOutput(output);

        }
        catch (Exception ex)
        {
            result.setCommandResult("FAILED");
            result.setResultOutput(ex.getMessage());
        }

        return result;
    }
}
