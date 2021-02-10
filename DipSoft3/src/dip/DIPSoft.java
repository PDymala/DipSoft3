package dip;

import java.awt.Color;
import java.io.IOException;
import java.util.function.BinaryOperator;

import modulesRaster.*;
import modulesVectors.VectorHologram;
import modulesVectors.VectorHologram2;
import modulesVectors.VectorHologram3;
import modulesVectors.VectorHologram4;
import modulesVectors.VectorHologram5;
import modulesVectors.VectorHologram6;


/**
* Program do obrï¿½bki obrazu DIPSoft
* Wersja: in progress
*/

public class DIPSoft {

	// need a converter from mm to px/float so that a person types size plus DPI (list?)
	
	public static void main (String[] args) throws IOException { 
		
		
		PlayingGround pG = new PlayingGround();
		
		
		// klasa main
/*	String url = "C:\\Users\\Piotr\\PrivateWorkspace\\DipSoft3\\src\\images\\";
	BufImage BIin = new BufImage(url+"horse-png-images-4.png");
	
	ThresholdAuto tA = new ThresholdAuto(BIin.getImage());
	BufImage BIout = new BufImage(tA.getThresholdAuto2(0.15, 0.05), BufImage.OutputFileType.PNG, url+"ThresholdAuto15.10.png");
	*/
	
	
	//loader SCREENV4_LETTERS i pixelV2
	
	
//BlackAndWhite obj1 = new BlackAndWhite(BIin.getImage(), BlackAndWhite.Method.luminosity); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
//BufImage BIout = new BufImage(obj1.getImageOut(), BufImage.OutputFileType.PNG, url+"ncpBRWlumi.png");
	/*
	ScreeningV1_2_DynamicScreen obj2 = new ScreeningV1_2_DynamicScreen(BIin.getImage(), "DIP", 15,15 ,  10f, 400, 100); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
	BufImage BIoutk = new BufImage(obj2.getImageOut(), BufImage.OutputFileType.PNG, url+"ScreenV1_2_DynamicScreen.png");
	
	ScreeningV1_2_StaticScreen obj3 = new ScreeningV1_2_StaticScreen(BIin.getImage(), "DIP", 15,15 , 10f, 400  ); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
	BufImage BIout1 = new BufImage(obj3.getImageOut(), BufImage.OutputFileType.PNG, url+"ScreeningV1_2_StaticScreen.png");		
	
	ScreeningV1_2_DynamicScreen2 obj4 = new ScreeningV1_2_DynamicScreen2(BIin.getImage(), "DIP", 15,15 ,  10f, 400, 100); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
	BufImage BIout2 = new BufImage(obj4.getImageOut(), BufImage.OutputFileType.PNG, url+"ScreeningV1_2_DynamicScreen2.png");
		
	ScreeningV1_2_DynamicScreen3 obj5 = new ScreeningV1_2_DynamicScreen3(BIin.getImage(), "DIP", 15,15 ,  10f, 20f, 400, 100); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
	BufImage BIout3 = new BufImage(obj5.getImageOut(), BufImage.OutputFileType.PNG, url+"ScreeningV1_2_DynamicScreen3.png");
	
ScreeningV1_2_DynamicScreen4 obj6 = new ScreeningV1_2_DynamicScreen4(BIin.getImage(), "DIP", 25,25 ,  10f, 40f, 400, 65); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
BufImage BIout4 = new BufImage(obj6.getImageOut(), BufImage.OutputFileType.PNG, url+"ScreeningV1_2_DynamicScreen4.png");
	
	Dithering2 obj7 = new Dithering2(BIin.getImage(), Dithering2.DitheringType.RANDOM, 5,5,3); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
	BufImage BIout5 = new BufImage(obj7.getImageOut(), BufImage.OutputFileType.PNG, url+"Dithering2_RANDOM.png");
	
	ThresholdingManual2 obj8 = new ThresholdingManual2(BIin.getImage(), 250); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
	BufImage BIout6 = new BufImage(obj8.getImageOut(), BufImage.OutputFileType.PNG, url+"ThresholdingManual2_standard.png");
		
	ThresholdingManual2 obj9 = new ThresholdingManual2(BIin.getImage(),  5,5,3, 250); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
	BufImage BIout7 = new BufImage(obj9.getImageOut(), BufImage.OutputFileType.PNG, url+"ThresholdingManual2_dots.png");
	
	Blurr2 obj10 = new Blurr2(BIin.getImage(),Blurr2.TypeOfBlurr.MEAN); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
 BufImage BIout8 = new BufImage(obj10.getImageOut(), BufImage.OutputFileType.PNG, url+"Blurr2_MEAN.png");
	
	int[] customMatrix= {1,50,1,50,1,50,1,50,1};
	Blurr2 obj11 = new Blurr2(BIin.getImage(), customMatrix); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
	BufImage BIout9 = new BufImage(obj11.getImageOut(), BufImage.OutputFileType.PNG, url+"Blurr2_CUSTOM1_50.png");
	
	int[] customMatrix2= {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	Blurr2 obj12 = new Blurr2(BIin.getImage(), customMatrix2, 5); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
	BufImage BIout10 = new BufImage(obj12.getImageOut(), BufImage.OutputFileType.PNG, url+"Blurr2_CUSTOM1_size5.png");
	
	
	*/
	//works but oweful- has timer ! :)
//	PixelationV2 obj16 = new PixelationV2(BIin.getImage(), 100,2); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
//	BufImage BIout = new BufImage(obj16.getImageOut(), BufImage.OutputFileType.PNG, url+"PixelationV2_50_2_NEW_FUNCTION.png");
	
	
	
	
	
/*	BufImage BIin13 = new BufImage(url+"EdgeDetectionV3_meanblurr5x5.png");	
	BufImage BIin14 = new BufImage(url+"ScreeningV4_Letters.png");	
	PictureEqualitions obj15 = new PictureEqualitions(BIin13.getImage(), BIin14.getImage(), PictureEqualitions.TypeOfEqualition.ADDING, 0,0);
	BufImage BIout11 = new BufImage(obj15.getImageOut(), BufImage.OutputFileType.PNG, url+"PictureEqualitionsAdding.png");
	*/
/*	
EdgeDetectionV3 obj15 = new EdgeDetectionV3(BIin.getImage(), 60, EdgeDetectionV3.ColorOutput.ONEBIT);
BufImage BIout = new BufImage(obj15.getImageOut(), BufImage.OutputFileType.PNG, url+"EdgeDetectionV3_no_blurr.png");
	
	
	
int[] customMatrix= {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
Blurr2 obj16 = new Blurr2(BIin.getImage(), customMatrix, 5); // ï¿½adujemy program do przerabiania obrazu na czarï¿½ i biel
EdgeDetectionV3 obj1 = new EdgeDetectionV3(obj16.getImageOut(), 60, EdgeDetectionV3.ColorOutput.ONEBIT);
BufImage BIout1 = new BufImage(obj1.getImageOut(), BufImage.OutputFileType.PNG, url+"EdgeDetectionV3_meanblurr5x5.png");
	
EdgeDetectionV3 obj2 = new EdgeDetectionV3(BIin.getImage(), 60, EdgeDetectionV3.EdgeDirection.BOTH);
BufImage BIout2 = new BufImage(obj2.getImageOut(), BufImage.OutputFileType.PNG, url+"EdgeDetectionV3_no_blurr_EdgeDirection.BOTH.png");
	
	
EdgeDetectionV3 obj3 = new EdgeDetectionV3(BIin.getImage(), 60, EdgeDetectionV3.EdgeDirection.BOTH, EdgeDetectionV3.ColorOutput.FULLCOLOR);
BufImage BIout3 = new BufImage(obj3.getImageOut(), BufImage.OutputFileType.PNG, url+"EdgeDetectionV3_no_blurr_EdgeDirection.BOTH_ColorOutput.FULLCOLOR.png");
		
ScreeningV4 obj4 = new ScreeningV4(BIin.getImage(), "DIP", 30f, 80);
BufImage BIout4 = new BufImage(obj4.getImageOut(), BufImage.OutputFileType.PNG, url+"ScreeningV4_standard.png");
	
ScreeningV4 obj5 = new ScreeningV4(BIin.getImage(), "DIP", 30f, 80, ScreeningV4.ScreenDirection.BOTTOMRIGHT);
BufImage BIout5 = new BufImage(obj5.getImageOut(), BufImage.OutputFileType.PNG, url+"ScreeningV4_ScreenDirection.BOTTOMRIGHT.png");

ScreeningV4 obj6 = new ScreeningV4(BIin.getImage(), "DIP", 30f, 80, 1000, 1000);
BufImage BIout6 = new BufImage(obj6.getImageOut(), BufImage.OutputFileType.PNG, url+"ScreeningV4_Point1000x1000.png");
	
		
ScreeningV4 obj7 = new ScreeningV4(BIin.getImage(), "DIP", 30f, 80, 45);
BufImage BIout7 = new BufImage(obj7.getImageOut(), BufImage.OutputFileType.PNG, url+"ScreeningV4_Angle45.png");
		

String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";

ScreeningV4_letters obj8 = new ScreeningV4_letters(BIin.getImage(), text, 40f, 110);
BufImage BIout8 = new BufImage(obj8.getImageOut(), BufImage.OutputFileType.PNG, url+"ScreeningV4_Letters.png");
	

//ScreeningV5_Edges2 obj9 = new ScreeningV5_Edges2(BIin.getImage(), ScreeningV5_Edges2.EdgeType.COLORBASE, "DIP", 30f);
//BufImage BIout9 = new BufImage(obj9.getImageOut(), BufImage.OutputFileType.PNG, url+"ScreeningV5_COLORBASEtest.png");
			

//ScreeningV5_Edges2 obj10 = new ScreeningV5_Edges2(BIin.getImage(), ScreeningV5_Edges2.EdgeType.EDGEDIRECTION, "DIP", 30f);
//BufImage BIout10 = new BufImage(obj10.getImageOut(), BufImage.OutputFileType.PNG, url+"ScreeningV5_EDGEDIRECTION.png");

/*
EDGEDIRECTION kiepsko dziala na zdjeciu. Natomiat na prostym ksztaï¿½cie caï¿½kiem ok.
Na zdjeciu duzo lepiej COLORBASE

String url2 = "C:\\Users\\Piotr\\PrivateWorkspace\\DipSoft3\\src\\images\\";
BufImage BIin2 = new BufImage(url+"circle.tiff");	

ScreeningV5_Edges2 obj802 = new ScreeningV5_Edges2(BIin2.getImage(), ScreeningV5_Edges2.EdgeType.EDGEDIRECTION, "DIP", 5f);
BufImage BIout2 = new BufImage(obj802.getImageOut(), BufImage.OutputFileType.PNG, url+"circle.png");
	/*

// teï¿½ slabe :)

*/ 
//ScreeningV5_Edges2 obj80 = new ScreeningV5_Edges2(BIin.getImage(), "DIP", 10f, 45, 20);
//BufImage BIout = new BufImage(obj80.getImageOut(), BufImage.OutputFileType.PNG, url+"ScreeningV5_Edges2_2angles.png");

/*
	BufImage BIin2 = new BufImage(url+"PixelationV2_20_5.png");	
ColorInversion obj21 = new ColorInversion(BIin2.getImage());
BufImage BIout = new BufImage(obj21.getImageOut(), BufImage.OutputFileType.PNG, url+"PixelationV2_20_5_inverted.png");
*/

//	ColorMixer obj8 = new ColorMixer(BIin.getImage(), 100,0,0); // 
//	BufImage BIout = new BufImage(obj8.getImageOut(), BufImage.OutputFileType.PNG, url+"ColorMixer.png");

	

//	Contrast obj9 = new Contrast(BIin.getImage(), 0, 0.99); 
//	BufImage BIout = new BufImage(obj9.getImageOut(), BufImage.OutputFileType.PNG, url+"Contrast.png");

	
	

	
	
	
/*BufImage BIin2 = new BufImage(url+"texttest.png");	
GhostMark obj8 = new GhostMark(BIin.getImage(),BIin2.getImage(),-50,-50,-50); // 
BufImage BIout = new BufImage(obj8.getImageOut(), BufImage.OutputFileType.PNG, url+"GhostMark.png");
*/

/*	
BufImage BIin2 = new BufImage(url+"ScreeningV5_Edges2_2angles.png");	
GhostMark obj8 = new GhostMark(BIin.getImage(),BIin2.getImage(),-50,-50,-50); // 
BufImage BIout34 = new BufImage(obj8.getImageOut(), BufImage.OutputFileType.PNG, url+"GhostMark2.png");
	*/		
	

	//ENHANCE THE EDGES nonsense :)
	/*
BufImage BIin2 = new BufImage(url+"EdgeDetectionV3_meanblurr5x5.png");	
GhostMark obj8 = new GhostMark(BIin.getImage(),BIin2.getImage(),-250,-250,-250); // 
BufImage BIout34 = new BufImage(obj8.getImageOut(), BufImage.OutputFileType.PNG, url+"GhostMarkEnhanceEdge.png");
*/

	/*
	
	BufImage BIin1 = new BufImage(url+"b.png");
	BufImage BIin2 = new BufImage(url+"a.png");
	

	
	TruthTableOperator o1 = new TruthTableOperator(BIin1.getImage(), BIin2.getImage(), TruthTableOperator.Method.CONTRADICTION);
	BufImage o1out = new BufImage(o1.getImageOut(), BufImage.OutputFileType.PNG, url+"CONTRADICTION.png");
	
	TruthTableOperator o2 = new TruthTableOperator(BIin1.getImage(), BIin2.getImage(), TruthTableOperator.Method.NOR);
	BufImage o2out = new BufImage(o2.getImageOut(), BufImage.OutputFileType.PNG, url+"NOR.png");
	
	TruthTableOperator o3 = new TruthTableOperator(BIin1.getImage(), BIin2.getImage(), TruthTableOperator.Method.PNEGATION);
	BufImage o3out = new BufImage(o3.getImageOut(), BufImage.OutputFileType.PNG, url+"PNEGATION.png");
	
	TruthTableOperator o4 = new TruthTableOperator(BIin1.getImage(), BIin2.getImage(), TruthTableOperator.Method.NONIMPLICATION);
	BufImage o4out = new BufImage(o4.getImageOut(), BufImage.OutputFileType.PNG, url+"NONIMPLICATION.png");
	
	TruthTableOperator o5 = new TruthTableOperator(BIin1.getImage(), BIin2.getImage(), TruthTableOperator.Method.QNEGATION);
	BufImage o5out = new BufImage(o5.getImageOut(), BufImage.OutputFileType.PNG, url+"QNEGATION.png");
	
	TruthTableOperator o6 = new TruthTableOperator(BIin1.getImage(), BIin2.getImage(), TruthTableOperator.Method.EXCLUSIVE);
	BufImage o6out = new BufImage(o6.getImageOut(), BufImage.OutputFileType.PNG, url+"EXCLUSIVE.png");
	
	TruthTableOperator o7 = new TruthTableOperator(BIin1.getImage(), BIin2.getImage(), TruthTableOperator.Method.STROKE);
	BufImage o7out = new BufImage(o7.getImageOut(), BufImage.OutputFileType.PNG, url+"STROKE.png");
	
	TruthTableOperator o8 = new TruthTableOperator(BIin1.getImage(), BIin2.getImage(), TruthTableOperator.Method.CONJUCTION);
	BufImage o8out = new BufImage(o8.getImageOut(), BufImage.OutputFileType.PNG, url+"CONJUCTION.png");
	
	TruthTableOperator o9 = new TruthTableOperator(BIin1.getImage(), BIin2.getImage(), TruthTableOperator.Method.LOGICALBICONDITIONAL);
	BufImage o9out = new BufImage(o9.getImageOut(), BufImage.OutputFileType.PNG, url+"LOGICALBICONDITIONAL.png");
	
	TruthTableOperator o10 = new TruthTableOperator(BIin1.getImage(), BIin2.getImage(), TruthTableOperator.Method.CONVERSEIMPLICATION);
	BufImage o10out = new BufImage(o10.getImageOut(), BufImage.OutputFileType.PNG, url+"CONVERSEIMPLICATION.png");
	
	TruthTableOperator o11 = new TruthTableOperator(BIin1.getImage(), BIin2.getImage(), TruthTableOperator.Method.ALTERNATION);
	BufImage o11out = new BufImage(o11.getImageOut(), BufImage.OutputFileType.PNG, url+"ALTERNATION.png");
	
	TruthTableOperator o12 = new TruthTableOperator(BIin1.getImage(), BIin2.getImage(), TruthTableOperator.Method.TAUTOLOGT);
	BufImage o12out = new BufImage(o12.getImageOut(), BufImage.OutputFileType.PNG, url+"TAUTOLOGT.png");
	
	
	*/
	

/*	VectorHologram5 obj16 = new VectorHologram5(BIin.getImage(), 3,3,17, false); 
	VectorHologram5 obj161 = new VectorHologram5(BIin.getImage(), 5,5,5, false); 
	VectorHologram5 obj162 = new VectorHologram5(BIin.getImage(), 5,5,9, false); 
	VectorHologram5 obj163 = new VectorHologram5(BIin.getImage(), 5,5,15, false); 
	
	VectorHologram5 obj162s = new VectorHologram5(BIin.getImage(), 10,10,3, false); 
	VectorHologram5 obj1612 = new VectorHologram5(BIin.getImage(), 10,10,5, false); 
	VectorHologram5 obj1622 = new VectorHologram5(BIin.getImage(), 10,10,9, false); 
	VectorHologram5 obj1632 = new VectorHologram5(BIin.getImage(), 10,10,15, false); 
*/	

//VectorHologram6 obj1632 = new VectorHologram6(BIin.getImage(), 50,50,1, false); 


// :D 
  //  RasterHologram5 obj1632 = new RasterHologram5(BIin.getImage(), 30, 30,1, false);
//	BufImage BIout = new BufImage(obj1632.getImageOut(), BufImage.OutputFileType.PNG, url+"RasterHologram5_30.30.1.png");


	//Resizer resizer = new Resizer();
	
	//BufImage BIout = new BufImage(resizer.resize(BIin.getImage(), BIin.getImage().getHeight()*8, BIin.getImage().getWidth()*8), BufImage.OutputFileType.PNG, url+"horse-png-images-4_resize_x8.png");

	
	/*





*/


/*
 * FIX ME! :)
PixelExplosion pX = new PixelExplosion(BIin.getImage(), 100000, 20, 7500,8000);
BufImage BIout = new BufImage(pX.getImageOut(), BufImage.OutputFileType.PNG, url+"PixelExplosion_10000_0_500_500_1stTEST.png");
*/

/*
	 * 
	BufImage BIin = new BufImage(url+"horse-png-images-4_noalpha.jpg");
	
	RHINOImage obj9 = new RHINOImage(BIin.getImage(), 500); 
	BufImage BIout = new BufImage(obj9.getImageOut(), BufImage.OutputFileType.PNG, url+"RHINO_500_noalpha.png");

	*/
	
/*	BufImage BIin = new BufImage(url+"horse-png-images-4noAlpha.png");

	//CMY
//	Color[] colorPalette = {new Color(255,255,0), new Color(255,0,255), new Color(0,0,255)};
	
	//RGB
	//Color[] colorPalette = {new Color(255,0,0), new Color(0,0,255), new Color(0,255, 0)};
	
	//WindRises
	//Color[] colorPalette = {new Color(255,255,255), Color.decode("#C0C197"), Color.decode("#949A82"),Color.decode("#80784B"),Color.decode("#8D5144"),Color.decode("#47352D")};
	
	//0601Daily
	//Color[] colorPalette = {new Color(255,255,255), Color.decode("#211F2B"), Color.decode("#103531"),Color.decode("#124B39"),Color.decode("#1CB57A"),Color.decode("#E5C32A")};
	
	//Ocean and sea life
	Color[] colorPalette = {new Color(255,255,255), Color.decode("#C6D0DD"), Color.decode("#81C3DB"),Color.decode("#728DA3"),Color.decode("#56656F"),Color.decode("#45545B")};
	
	//random 8 colors
	//Color[] colorPalette = {new Color(255,255,255), new RandomColor().getColor(), new RandomColor().getColor(), new RandomColor().getColor(), new RandomColor().getColor(), new RandomColor().getColor(), new RandomColor().getColor(), new RandomColor().getColor(), new RandomColor().getColor()};
	ColorPaletteTransformation obj9 = new ColorPaletteTransformation(BIin.getImage(), colorPalette); 

	
	//random 50 colors
//	ColorPaletteTransformation obj9 = new ColorPaletteTransformation(BIin.getImage(), new RandomColor().getColorSet(20)); 
	BufImage BIout = new BufImage(obj9.getImageOut(), BufImage.OutputFileType.PNG, url+"ColorPaletteTransformationOceanAndLife_TGBPythagoraDistance.png");

	*/
	
//	BufImage BIin = new BufImage(url+"horse-png-images-4.png");
//	AveragePixel avPixel = new AveragePixel(BIin.getImage());
	
//	ThresholdingManual2 obj8 = new ThresholdingManual2(BIin.getImage(), avPixel.getAvPixel().getRgbSum());
//	BufImage BIout6 = new BufImage(obj8.getImageOut(), BufImage.OutputFileType.PNG, url+"ThresholdingManual2_standard_averagePixel.png");
	
	
//	BufImage BIin = new BufImage(url+"horse-png-images-4.png");
//	ImageDestroyer obj8 = new ImageDestroyer(BIin.getImage(), 5.0, ImageDestroyer.Method.empty, 2);
//	BufImage BIout6 = new BufImage(obj8.getImageOut(), BufImage.OutputFileType.PNG, url+"ImageDestroyer_black_5_10x10.png");
	
	
	/*
	BufImage BIin = new BufImage(url+"horse-png-images-4.png");
	ImageDestroyer obj8 = new ImageDestroyer(BIin.getImage(), 5.0, 2.0);
BufImage BIout6 = new BufImage(obj8.getImageOut(), BufImage.OutputFileType.PNG, url+"ImageDestroyer_copySegments_5_4x4.png");
	
	*/
	/*BufImage BIin = new BufImage(url+"horse-png-images-4mini.png");
	ImigmaColor imigmaColor = new ImigmaColor(BIin.getImage(), "aaav");
	BufImage BIout6 = new BufImage(imigmaColor.getImageOut(), BufImage.OutputFileType.PNG, url+"imigmaColorAAAA.png");


	BufImage BIin2 = new BufImage(url+"imigmaColorAAAA.png");
	ImigmaColor imigmaColorRev = new ImigmaColor(BIin2.getImage(), "aaav");
	BufImage BIout66 = new BufImage(imigmaColorRev.getImageOut(), BufImage.OutputFileType.PNG, url+"imigmaColorAAAA_rev.png");
*/
/*	
BufImage BIin2 = new BufImage(url+"horse-png-images-4.png");
	DigiCode1 digiCode = new DigiCode1(BIin2.getImage(), 1,1,1, DigiCode1.Method.code);
	BufImage BIout66 = new BufImage(digiCode.getImageOut(), BufImage.OutputFileType.PNG, url+"digiCode_coded_PictureWithCode.png");


	BufImage BIin21 = new BufImage(url+"digiCode_coded_PictureWithCode.png");
	//DigiCode1 digiCode2 = new DigiCode1(BIin21.getImage(), 15,16,17, DigiCode1.Method.decode);
	//BufImage BIout66o = new BufImage(digiCode2.getImageOut(), BufImage.OutputFileType.PNG, url+"digiCode_coded_PictureWithCode_DECODED.png");

	
	BufImage BIin2o = new BufImage(url+"horse-png-images-4.png");
	//DigiCode1 digiCode3 = new DigiCode1(BIin2o.getImage(), 15,16,17, DigiCode1.Method.decode);
	//BufImage BIout66p = new BufImage(digiCode3.getImageOut(), BufImage.OutputFileType.PNG, url+"digiCode_coded_PictureWithoutCode_DECODED.png");

	
	ImageComperator imageComperator = new ImageComperator(BIin2.getImage(), BIin2o.getImage());
	*/
	
/*
BufImage BIin2 = new BufImage(url+"horse-png-images-4.png");
	DigiCode2 digiCode = new DigiCode2(BIin2.getImage(), 2,3,4, DigiCode2.Method.code);
	BufImage BIout66 = new BufImage(digiCode.getImageOut(), BufImage.OutputFileType.PNG, url+"digiCode2_coded_PictureWithCode.png");


	BufImage BIin21 = new BufImage(url+"digiCode2_coded_PictureWithCode.png");
	DigiCode2 digiCode2 = new DigiCode2(BIin21.getImage(), 2,3,4, DigiCode2.Method.decode);
	BufImage BIout66o = new BufImage(digiCode2.getImageOut(), BufImage.OutputFileType.PNG, url+"digiCode2_coded_PictureWithCode_DECODED.png");


	BufImage BIin212 = new BufImage(url+"digiCode2_coded_PictureWithCode.png");
	DigiCode2 digiCode23 = new DigiCode2(BIin212.getImage(), 5,6,7, DigiCode2.Method.decode);
	BufImage BIout66os = new BufImage(digiCode23.getImageOut(), BufImage.OutputFileType.PNG, url+"digiCode2_coded_PictureWithCode_DECODED_wrongCode.png");

	
	
	BufImage BIin2o = new BufImage(url+"horse-png-images-4.png");
	//DigiCode1 digiCode3 = new DigiCode1(BIin2o.getImage(), 15,16,17, DigiCode1.Method.decode);
	//BufImage BIout66p = new BufImage(digiCode3.getImageOut(), BufImage.OutputFileType.PNG, url+"digiCode_coded_PictureWithoutCode_DECODED.png");

	*/
//	ImageComperator imageComperator = new ImageComperator(BIin2.getImage(), BIin2o.getImage());

	/*
	BufImage BI1 = new BufImage(url+"horse-png-images-4noAlpha.png");
	BufImage BI2 = new BufImage(url+"cat.jpg");
	
	DigiCode3_hiddenImage digiCode = new DigiCode3_hiddenImage(BI1.getImage(), BI2.getImage(), 2,3,4, DigiCode3_hiddenImage.Method.code);
	BufImage BIout66 = new BufImage(digiCode.getImageOut(), BufImage.OutputFileType.PNG, url+"DigiCode3_hiddenImage_coded_PictureWithhiddenPicture.png");

//zmienic digi3 przy decode ze nie musi miec drugigoe obrazu albo uzywac 2ki
	BufImage BIin21 = new BufImage(url+"DigiCode3_hiddenImage_coded_PictureWithhiddenPicture.png");
	DigiCode2 digiCode2 = new DigiCode2(BIin21.getImage(), 2,3,4, DigiCode2.Method.decode);
	BufImage BIout66o = new BufImage(digiCode2.getImageOut(), BufImage.OutputFileType.PNG, url+"DigiCode3_hiddenImage_coded_PictureWithhiddenPicture_DECODED.png");


	BufImage BIin21s = new BufImage(url+"DigiCode3_hiddenImage_coded_PictureWithhiddenPicture.png");
	DigiCode2 digiCode2s = new DigiCode2(BIin21s.getImage(), 5,6,7, DigiCode2.Method.decode);
	BufImage BIout66os = new BufImage(digiCode2s.getImageOut(), BufImage.OutputFileType.PNG, url+"DigiCode3_hiddenImage_coded_PictureWithhiddenPicture_DECODED_wrongCODE.png");
	
	
	//DigiCode1 digiCode3 = new DigiCode1(BIin2o.getImage(), 15,16,17, DigiCode1.Method.decode);
	//BufImage BIout66p = new BufImage(digiCode3.getImageOut(), BufImage.OutputFileType.PNG, url+"digiCode_coded_PictureWithoutCode_DECODED.png");
*/
	
	
	/*
BufImage BIin = new BufImage(url+"horse-png-images-4.png");
ImigmaColorSimple imigmaColorSimple = new ImigmaColorSimple(BIin.getImage(), "AAAV", ImigmaColorSimple.Method.code);
BufImage BIout6 = new BufImage(imigmaColorSimple.getImageOut(), BufImage.OutputFileType.PNG, url+"imigmaColorSimpleAAAV.png");

BufImage BIin2 = new BufImage(url+"imigmaColorSimpleAAAV.png");
ImigmaColorSimple imigmaColorSimple2 = new ImigmaColorSimple(BIin2.getImage(), "AAAV", ImigmaColorSimple.Method.decode);
BufImage BIout61 = new BufImage(imigmaColorSimple2.getImageOut(), BufImage.OutputFileType.PNG, url+"imigmaColorSimpleAAAV_rev.png");
*/
	
	
	
	

	/*
	 
	 VECTOR SHAPE zrobic?
	 
	***Zrobic program do wizualizacji VectorHologram
	- niech robi GIFy. w kazdej klatce inny kat. Dodatkowo mozliwosc ustawienia koloru tla, wtedy kolor sie zmienia. Moze byc jeden jasniejszy (ten aktywny) a inny ciemniejszy.
	Albo tylko aktywny widac na klatce?
	 
	 
	 
	IMIGMA dalsze:
	

	czy uzale¿niaæ piksele od ich pozycji? Po przyciêciu wtedy nie da siê odzyskaæ
	
	1) piksele od pozycji + baza + kod
	2) piksele z bazy + kod tylko ?
	3) piksele z bazy + kod + znacznik czasowy? (np. z utworzenia pliku :) ale z utworzenia tego kodowanego. nie oryginalnego. Czyli musi brac date dziesiejsza
	
	wersja czarno biala czy kolorowa?
	
	
	
	CZYTANIE KODU z obrazka:
	
	- kreskowy ? czyli szuka po obrazku ci¹gu kolorów rozpoczynaj¹cych sekwencje, tj. np. 1 bia³y, 2 czarne, 1 bia³y lub ich mno¿enie
	
	
	NEURONETWORK
	
	- czytanie obrazka i sortowanie w zlae¿noœci od IMAGE DESTROYER lub podonych
	
	
	
	INNE
	jak zrobic edge detection na wektory? i jeszcze aby sczytac pola powierzchni tych elementow :D
	
	
	
	
	
	*/
	
	/*
	int cores = Runtime.getRuntime().availableProcessors();
	ThreadsAvailable threads = new ThreadsAvailable();
	System.out.println("Physical threads:" + threads.getNumberOfCPUCores());
	System.out.println("Logical threads" + cores); 
	
	We have 2 physical threads and 4 logical (ie hyperthreading is available). Does that mean that we can use 4 threads at once or more?
	**/
	
	

/*
	BufImage BIin = new BufImage(url+"cat.jpg");
	DigiCode4_binaryTextCoding2_array digiCode4_binaryTextCoding = new DigiCode4_binaryTextCoding2_array(BIin.getImage(),  "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
	BufImage BIout6 = new BufImage(digiCode4_binaryTextCoding.getImageOut(), BufImage.OutputFileType.PNG, url+"DigiCode4_binaryTextCoding2_array_fulltext.png");


	BufImage BIinW = new BufImage(url+"DigiCode4_binaryTextCoding2_array_fulltext.png");
	DigiCode4_binaryTextCoding2_array digiCode4_binaryTextCodingW = new DigiCode4_binaryTextCoding2_array(BIinW.getImage());
*/
	/*
	BufImage BIin = new BufImage(url+"cat.jpg");
	DigiCode4_binaryTextCoding2_array_condensed digiCode4_binaryTextCoding = new DigiCode4_binaryTextCoding2_array_condensed(BIin.getImage(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
	BufImage BIout6 = new BufImage(digiCode4_binaryTextCoding.getImageOut(), BufImage.OutputFileType.PNG, url+"DigiCode4_binaryTextCoding2_array_fulltext_condensed.png");
*/
/*
	BufImage BIin = new BufImage(url+"horse-png-images-4.png");
	EdgeDetectionV3 obj15 = new EdgeDetectionV3(BIin.getImage(), 60, EdgeDetectionV3.EdgeDirection.BOTH,  EdgeDetectionV3.ColorOutput.AVERAGE);
	BufImage BIout = new BufImage(obj15.getImageOut(), BufImage.OutputFileType.PNG, url+"EdgeDetectionV3_edgeDirectionBoth_Color_Average.png");
*/
/*
	BufImage BIin = new BufImage(url+"horse-png-images-4.png");
	GibberishLines gl = new GibberishLines(BIin.getImage(), 100000, GibberishLines.ColorType.AVERAGE);
	BufImage BIout = new BufImage(gl.getImageOut(), BufImage.OutputFileType.PNG, url+"GibberishLinesHorse__continousLine_100000_color_Average_alpha.png");
	*/
	
/*	BufImage BIin = new BufImage(url+"horse-png-images-4.png");
	ShapeDistorsion gl = new ShapeDistorsion(BIin.getImage(), 10,50,3000,ShapeDistorsion.Shape.CIRCLE); //cos sie psuje przy duzych wielkosciach
	BufImage BIout = new BufImage(gl.getImageOut(), BufImage.OutputFileType.PNG, url+"ShapeDistorsion_10_500__3000_circle.png");
	*/
	
	/*
	BufImage BIin = new BufImage(url+"cat.jpg");
	ColorShift gl = new ColorShift(BIin.getImage(), ColorShift.ColorType.RANDOM); //cos sie psuje przy duzych wielkosciach
	BufImage BIout = new BufImage(gl.getImageOut(), BufImage.OutputFileType.JPG, url+"ColorShift_Random_CAT.jpg"); //dziwne....
	*/
	
/*
	BufImage BIin = new BufImage(url+"horse-png-images-4.png");
	Diffusing gl = new Diffusing(BIin.getImage(), 50,50,1); //cos sie psuje przy duzych wielkosciach
	BufImage BIout = new BufImage(gl.getImageOut(), BufImage.OutputFileType.PNG, url+"Diffusing_50.50.1.PNG"); //dziwne....
	*/
	// mo¿e matrixy zamiast pisela ? :)
	
	
//
//	NonCopyPicture ncp = new NonCopyPicture(BIin.getImage());
//	BufImage BIout6 = new BufImage(ncp.getImageOut(), BufImage.OutputFileType.PNG, url+"ncp2.png");

	
	System.out.println("Picture ready!");
	
	}

}
