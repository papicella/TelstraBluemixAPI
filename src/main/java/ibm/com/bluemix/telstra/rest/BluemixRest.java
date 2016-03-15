package ibm.com.bluemix.telstra.rest;

import ibm.com.bluemix.telstra.commands.Command;
import ibm.com.bluemix.telstra.commands.OsCommand;
import ibm.com.bluemix.telstra.main.Constants;
import ibm.com.bluemix.telstra.main.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/apis")
public class BluemixRest
{
    @ApiOperation(value = "createOrg", nickname = "createOrg")
    @RequestMapping(method=RequestMethod.GET, value="/create/{orgName}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Result.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
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

    @ApiOperation(value = "deleteOrg", nickname = "deleteOrg")
    @RequestMapping(method=RequestMethod.GET, value="/delete/{orgName}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Result.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
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
