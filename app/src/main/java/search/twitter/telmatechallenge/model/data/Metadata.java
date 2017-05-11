package search.twitter.telmatechallenge.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by varsha on 5/10/17.
 */

public class Metadata {
    @SerializedName("iso_language_code")
    @Expose
    private String isoLanguageCode;
    @SerializedName("result_type")
    @Expose
    private String resultType;

    public Metadata() {
    }


    public String getIsoLanguageCode() {
        return isoLanguageCode;
    }

    public void setIsoLanguageCode(String isoLanguageCode) {
        this.isoLanguageCode = isoLanguageCode;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "isoLanguageCode='" + isoLanguageCode + '\'' +
                ", resultType='" + resultType + '\'' +
                '}';
    }
}
