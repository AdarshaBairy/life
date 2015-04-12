package main.java.edu.asu.cst316.cards;

import java.util.Random;

public class Deck {
	
	private static Deck deck = new Deck();
	
	private Card commonCards[];
	private Card redCards[];
	private Card greenCards[];
	
	private Deck(){
		commonCards = new Card[10];
		redCards = new Card[10];
		greenCards = new Card[10];
		
		//Populate the deck with cards
		commonCards[0] = new Card("Blue Space: You gain 4000", 4000);
		commonCards[1] = new Card("Your significant other wants a divorce and takes your money, you lose $3500", -3500);
		commonCards[2] = new Card("While at a rodeo a horse kicks you in the chest and breaks your ribs, for medical you pay $4000", -4000);
		commonCards[3] = new Card("Blue Space: You gain 3500", 3500);
		commonCards[4] = new Card("Your kids fought the law and the law won, pay $5000", -5000);
		commonCards[5] = new Card("Your company is not making much revenue you lose $3000", -3000);
		commonCards[6] = new Card("Blue Space: You gain 4000", 4000);
		commonCards[7] = new Card("A very loud horn shatters the windows of your building, to have them fixed it costs $2000", -2000);
		commonCards[8] = new Card("Blue Space: You gain 3000", 3000);
		commonCards[9] = new Card("Blue Space: You lose 3000", 3000);
		commonCards[10] = new Card("Blue Space: You gain 4000", 4000);
		commonCards[11] = new Card("The bees knees flat screen TV just came out and you buy it for $3500", -3500);
		commonCards[12] = new Card("Blue Space: You lose 4000", 4000);
		commonCards[13] = new Card("Blue Space: You gain 3500", 3500);
		commonCards[14] = new Card("A new smartphone has been released and you buy it for $5000", -5000);
		commonCards[15] = new Card("To fund your new hobby of hat collecting you pay $3000", -3000);
		commonCards[16] = new Card("Blue Space: You gain 4000", 4000);
		commonCards[17] = new Card("You strike conversation with a pretty girl and she maces your face, for medical pay $2000", -2000);
		commonCards[18] = new Card("Blue Space: You gain 3000", 3000);
		commonCards[19] = new Card("A wise wizard says for a fee he will teach you a spell to create bubbles, you pay $3000", -3000);
		commonCards[20] = new Card("Blue Space: You gain 4000", 4000);
		commonCards[21] = new Card("A bee stings you in the eye while walking in the park, for medical pay $3500", -3500);
		commonCards[22] = new Card("While on a morning jog your shoes break, for new shoes you pay $4000", -4000);
		commonCards[23] = new Card("Blue Space: You gain 3500", 3500);
		commonCards[24] = new Card("Blue Space: You lose 5000", 5000);
		commonCards[25] = new Card("You pay for marketing the company, it costs $3000", -3000);
		commonCards[26] = new Card("Blue Space: You gain 4000", 4000);
		commonCards[27] = new Card("You pay for the company electric bill, it costs $2000", -2000);
		commonCards[28] = new Card("Blue Space: You gain 3000", 3000);
		commonCards[29] = new Card("You cut your hand with a knife while cooking, for medical $3000", -3000);
		commonCards[30] = new Card("Blue Space: You gain 4000", 4000);
		commonCards[31] = new Card("Blue Space: You lose 3500", 3500);
		commonCards[32] = new Card("Your company buildings rent increased, you lose $4000", -4000);
		commonCards[33] = new Card("Blue Space: You gain 3500", 3500);
		commonCards[34] = new Card("An earthquake hits the city and damages your offices the cost is $5000", -5000);
		commonCards[35] = new Card("A tornado strikes your building to fix the damage it will cost $3000", -3000);
		commonCards[36] = new Card("Blue Space: You gain 4000", 4000);
		commonCards[37] = new Card("Blue Space: You lose 2000", 2000);
		commonCards[38] = new Card("Blue Space: You gain 3000", 3000);
		commonCards[39] = new Card("You have a leak in the roof of you building and heavy rain is expected it costs $3000", -3000);
		commonCards[40] = new Card("Blue Space: You gain 4000", 4000);
		
		redCards[0] = new Card("A tornado strikes your building to fix the damage it will cost $6000", -6000);
		redCards[1] = new Card("Red Space: You gain 8000", 8000);
		redCards[2] = new Card("Red Space: You gain 7000", 7000);
		redCards[3] = new Card("Red Space: You gain 11000", 11000);
		redCards[4] = new Card("An earthquake hits the city and damages your offices the cost is $7000", -7000);
		redCards[5] = new Card("A hurricane caused flooding in your building to fix the damage it costs $9000", -9000);
		redCards[6] = new Card("Your internet went down and you can no longer reach clients you lose $6000", -6000);
		redCards[7] = new Card("Your employees are demanding more pay, to keep them happy you pay them $9000", -9000);
		redCards[8] = new Card("Red Space: You gain 7500", 7500);
		redCards[9] = new Card("You have been the victim of Identity theft they stole $8000", -8000);
		redCards[10] = new Card("You have a leak in the roof of you building and heavy rain is expected it costs $6500", -6500);
		redCards[11] = new Card("Red Space: You gain 8000", 8000);
		redCards[12] = new Card("Red Space: You gain 7000", 7000);
		redCards[13] = new Card("Red Space: You gain 11000", 11000);
		redCards[14] = new Card("While on your morning jog a pit bull chased you and bit your leg, for medical you must pay $5000", -5000);
		redCards[15] = new Card("While walking to lunch you are struck by a bicycle and break your leg, for medical bills you pay $9000", -9000);
		redCards[16] = new Card("Your car battery is stolen and you must take the bus to work this costs you $6000", -6000);
		redCards[17] = new Card("Your grandma got run over by a rain deer, for funeral costs you pay $9000", -9000);
		redCards[18] = new Card("Red Space: You gain 7500", 7500);
		redCards[19] = new Card("A recent outbreak of disease infested mosquitos forces you to stay inside, while bored you play online gambling and lose $8000", -8000);
		redCards[20] = new Card("You company buildings rent increased, you lose $6000", -6000);
		redCards[21] = new Card("Red Space: You gain 8000", 8000);
		redCards[22] = new Card("Red Space: You gain 7000", 7000);
		redCards[23] = new Card("A mad man breaks into your building and sets it on fire, you must buy a new building for $11000", -11000);
		redCards[24] = new Card("While walking to lunch you get mugged and the mugger takes your money, you lose $5000", -5000);
		redCards[25] = new Card("Robots are plotting to take over your business, to have them scrapped and melted you pay $9000", -9000);
		redCards[26] = new Card("Your business suit is stolen from your car and you must buy a new one, you pay $6000", -6000);
		redCards[27] = new Card("On the way to work you get into a car accident, you must buy a new car and pay medical bills $9000", -9000);
		redCards[28] = new Card("Red Space: You gain 7500", 7500);
		redCards[29] = new Card("The economy has crashed your company is struggling, you lose $8000", -8000);
		redCards[30] = new Card("You see a lucky penny in the road and bend down to pick it up, you are struck by a car and break all of your teeth, for new teeth you pay $6000", -6000);
		redCards[31] = new Card("Red Space: You gain 8000", 8000);
		redCards[32] = new Card("Red Space: You gain 7000", 7000);
		redCards[33] = new Card("Red Space: You gain 11000", 11000);
		redCards[34] = new Card("An employee is angry with you and takes you to court for mal practices, lawyer’s fees are $5000", -5000);
		redCards[35] = new Card("You develop a new hobby of collecting rare space rocks, for funding your hobby you pay $9000", -9000);
		redCards[36] = new Card("Your car needs a new transmission to get a new one you pay $6000", -6000);
		redCards[37] = new Card("A French man tells you he has a great investment opportunity, you say yes and give him money, he is never seen again and scammed you. You lost $9000", -9000);
		redCards[38] = new Card("Red Space: You gain 7500", 7500);
		redCards[39] = new Card("A meteorite hits your house, to fix the damage pay $8000", -8000);
		redCards[40] = new Card("You total your car and have to buy a new one pay $8000", -8000);
				
				
				
		greenCards[0] = new Card("Green Space: You gain 2000", 2000);
		greenCards[1] = new Card("You ate bad sushi and must buy medicine pay $1000", -1000);
		greenCards[2] = new Card("Green Space: You lose 1000", 1000);
		greenCards[3] = new Card("Green Space: You gain 2000", 2000);
		greenCards[4] = new Card("You ate bad sushi and must buy medicine pay $2500", -2500);
		greenCards[5] = new Card("Green Space: You gain 3000", 3000);
		greenCards[6] = new Card("A cat walks into your house and you want to keep it, for vet fees pay $500", -500);
		greenCards[7] = new Card("Green Space: You lose 1500", 1500);
		greenCards[8] = new Card("Green Space: You gain 3000", 3000);
		greenCards[9] = new Card("A mysterious drifter convinces you to buy magical beans to buy them you pay $2000", -2000);
		greenCards[10] = new Card("Green Space: You gain 2000", 2000);
		greenCards[11] = new Card("Tall figures in an alley are staring at you, you give them your wallet to leave you alone, you lose $1000", -1000);
		greenCards[12] = new Card("Your car gets a flat tire, a new tire costs $1000", -1000);
		greenCards[13] = new Card("Green Space: You gain 2000", 2000);
		greenCards[14] = new Card("Monkey’s escaped the local zoo and you are bitten by one, the medical bill costs $2500", -2500);
		greenCards[15] = new Card("Green Space: You gain 3000", 3000);
		greenCards[16] = new Card("You want to see the pre-screening of a movie, it costs $500", -500);
		greenCards[17] = new Card("While at an aquarium the glass breaks and you are stung by a jelly fish, medical costs $1500", -1500);
		greenCards[18] = new Card("Green Space: You gain 3000", 3000);
		greenCards[19] = new Card("Green Space: You lose 2000", 2000);
		greenCards[20] = new Card("Green Space: You gain 2000", 2000);
		greenCards[21] = new Card("You pay someone to make a website for your business, it cost $1000", -1000);
		greenCards[22] = new Card("Green Space: You lose 1000", 1000);
		greenCards[23] = new Card("Green Space: You gain 2000", 2000);
		greenCards[24] = new Card("The economy has crashed your company is struggling, you lose $2500", -2500);
		greenCards[25] = new Card("Green Space: You gain 3000", 3000);
		greenCards[26] = new Card("Green Space: You lose 500", 500);
		greenCards[27] = new Card("Your car needs a new transmission to get a new one you pay $1500", -1500);
		greenCards[28] = new Card("Green Space: You gain 3000", 3000);
		greenCards[29] = new Card("Your business suit is stolen from your car and you must buy a new one, you pay $2000", -2000);
		greenCards[30] = new Card("Green Space: You gain 2000", 2000);
		greenCards[31] = new Card("Green Space: You lose 1000", 1000);
		greenCards[32] = new Card("Your kids fought the law and the law won, pay $1000", -1000);
		greenCards[33] = new Card("Green Space: You gain 2000", 2000);
		greenCards[34] = new Card("Green Space: You lose 2500", 2500);
		greenCards[35] = new Card("Green Space: You gain 3000", 3000);
		greenCards[36] = new Card("You company buildings rent increased, you lose $500", -500);
		greenCards[37] = new Card("The bees knees flat screen TV just came out and you buy it for $1500", -1500);
		greenCards[38] = new Card("Green Space: You gain 3000", 3000);
		greenCards[39] = new Card("You pay for the company electric bill, it costs $2000", -2000);
		greenCards[40] = new Card("Green Space: You gain 2000", 2000);
	}
	
	public static Deck getInstance(){
		return deck;
	}
	
	
	//Get a random common card from the deck
	public Card getCommonCard(){
		Random randomInt = new Random();
		int cardIndex = randomInt.nextInt(9);
		return commonCards[cardIndex];
	}
	
	//Get a random red card from the deck
	public Card getRedCard(){
		Random randomInt = new Random();
		int cardIndex = randomInt.nextInt(9);
		return redCards[cardIndex];
	}
	
	//Get a random green card from the deck
	public Card getGreenCard(){
		Random randomInt = new Random();
		int cardIndex = randomInt.nextInt(9);
		return greenCards[cardIndex];
	}
}
