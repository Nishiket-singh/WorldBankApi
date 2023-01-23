package DataFetching;

import DataFetching.GetData.ThrowException;

public interface GetDataProxy {

    Reply getData(APICall request) throws GetData.ThrowException;

}
