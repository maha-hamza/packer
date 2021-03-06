package com.mobiquityinc.packer.processing;

import static com.mobiquityinc.CustomAssert.assertObject;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mobiquityinc.configs.PackerInjector;
import com.mobiquityinc.packer.pojos.Item;
import com.mobiquityinc.packer.pojos.Package;

import junit.framework.TestCase;

public class TestPackaging extends TestCase {

	public void testPickAPackage() {
		Injector injector = Guice.createInjector(new PackerInjector());
		Packaging packaging = injector.getInstance(Packaging.class);

		Package pkg = new Package();
		pkg.setPackageMaximumWeight(81.0);
		List<Item> items = new ArrayList<>();
		items.add(new Item(1, 53.38, 45.0));
		items.add(new Item(2, 88.62, 98.0));
		items.add(new Item(3, 78.48, 3.0));
		items.add(new Item(4, 72.3, 76.0));
		items.add(new Item(5, 30.18, 9.0));
		items.add(new Item(6, 46.34, 48.0));
		pkg.setItems(items);

		List<Package> packages = new ArrayList<>();
		packages.add(pkg);
		assertObject("4\n", packaging.selectPackage(packages));
	}

}
