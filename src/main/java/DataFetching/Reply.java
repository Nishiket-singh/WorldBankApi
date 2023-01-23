package DataFetching;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Reply implements ReplyFacade{

    private JsonArray jsonArray;
    public Reply(String jsonStringResponse){

        jsonArray = new JsonParser().parse(jsonStringResponse).getAsJsonArray();
    }
    public Reply(){}

   private JsonArray getJsonArray(){
        return this.jsonArray;
    }

    public Double getValue(int year){
        int sizeOfResults = getSize();

        for(int i=0; i<sizeOfResults; i++){
            if(this.getYear(i) == year){
                if (this.getValueForIndex(i) == null){
                    return null;
                }
                return this.getValueForIndex(i);
            }
        }
        return null;
    }
    private int getYear(int i){
        return this.jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
    }

    private Double getValueForIndex(int i){
        JsonElement result = this.jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value");
        if(!result.isJsonNull()){
            return result.getAsDouble();
        }
        return null;
    }



    public int getSize(){
        return this.getJsonArray().get(1).getAsJsonArray().size();
    }
}
