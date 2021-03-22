package chapter_4_design_with_lambda.delegation_using_method_ref;

public class Asset {
    public enum AssetType{BOND,STOCK};
    private final AssetType type;
    private final int value;

    public Asset(AssetType type, int value) {
        this.type = type;
        this.value = value;
    }

    public AssetType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
