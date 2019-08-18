package designing.fpij;

public class Asset {

    public enum AssetType { BOND, STOCK }

    private final AssetType assetType;

    private final int assetValue;

    public Asset(final AssetType assetType, final int assetValue) {
        this.assetType = assetType;
        this.assetValue = assetValue;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public int getAssetValue() {
        return assetValue;
    }
}
