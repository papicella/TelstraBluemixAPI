package ibm.com.bluemix.telstra.main;

/**
 * Created by pasapicella on 15/03/2016.
 */
public class Result
{
    private String commandResult;
    private String resultOutput;

    public Result()
    {
    }

    public String getCommandResult() {
        return commandResult;
    }

    public void setCommandResult(String commandResult) {
        this.commandResult = commandResult;
    }

    public String getResultOutput() {
        return resultOutput;
    }

    public void setResultOutput(String resultOutput) {
        this.resultOutput = resultOutput;
    }

    @Override
    public String toString() {
        return "Result{" +
                "commandResult='" + commandResult + '\'' +
                ", resultOutput='" + resultOutput + '\'' +
                '}';
    }
}
