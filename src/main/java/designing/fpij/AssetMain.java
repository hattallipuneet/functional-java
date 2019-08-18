package designing.fpij;

import designing.fpij.Asset.AssetType;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class AssetMain {

    public static void main(String[] args) {

        Function<AssetType, Predicate<Asset>> assetTypeFilterFunction =
                assetType -> asset -> assetType.equals(asset.getAssetType());


        final List<Asset> assets = Arrays.asList(
                new Asset(Asset.AssetType.BOND, 1000),
                new Asset(Asset.AssetType.BOND, 2000),
                new Asset(Asset.AssetType.STOCK, 3000),
                new Asset(Asset.AssetType.STOCK, 4000)
        );

        System.out.println("Total of all assets "+ AssetUtil.totalAssetValues(assets));

        System.out.println("Total of all bond assets "+ AssetUtil.totalBondAssetValues(assets));

        System.out.println("Total of all stock assets "+ AssetUtil.totalStockAssetValues(assets));

        System.out.println("Total of all asset from refactored "+
                AssetUtilRefactored.totalAssetValues(assets, asset -> true));

        System.out.println("Total of all bond assets from refactored "+
                AssetUtilRefactored.totalAssetValues(assets, assetTypeFilterFunction.apply(AssetType.BOND)));

        System.out.println("Total of all stock assets from refactored "+
                AssetUtilRefactored.totalAssetValues(assets, assetTypeFilterFunction.apply(AssetType.STOCK)));

    }
}
