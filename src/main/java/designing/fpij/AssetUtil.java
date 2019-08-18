package designing.fpij;

import designing.fpij.Asset.AssetType;
import java.util.List;
import java.util.function.Predicate;


public class AssetUtil {

    private AssetUtil() {}

    public static int totalAssetValues(final List<Asset> assets) {
        return assets.stream()
                        .mapToInt(Asset::getAssetValue)
                        .sum();
    }

    public static int totalBondAssetValues(final List<Asset> assets) {
        return assets.stream()
                        .filter(asset -> asset.getAssetType().equals(AssetType.BOND))
                        .mapToInt(Asset::getAssetValue)
                        .sum();
    }

    public static int totalStockAssetValues(final List<Asset> assets) {
        return assets.stream()
                        .filter(asset -> AssetType.STOCK.equals(asset.getAssetType()))
                        .mapToInt(Asset::getAssetValue)
                        .sum();
    }
}
