/*----------------------------------------------------------------------------------------------------------------------
	Homework-015 için bir ipucu. Detaylar gözrmezden gelindi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Card [] deck;

		deck = Card.getShuffledDeck();

		for (Card card : deck)
			System.out.printf("%s-%s%n", card.getType(), card.getValue());
	}
}

class Card
{
	private CardValue m_value;
	private CardType m_type;
	//...

	public Card(CardValue v, CardType t)
	{
		m_value = v;
		m_type = t;
	}

	public CardValue getValue()
	{
		return m_value;
	}

	public CardType getType()
	{
		return m_type;
	}
	//....
	public static Card[] getShuffledDeck()
	{
		Card[] deck = new Card[52];

		int index = 0;

		for (CardType cardType : CardType.values())
			for (CardValue cardValue : CardValue.values())
				deck[index++] = new Card(cardValue, cardType);

		//...

		return deck;
	}

	//…
}


enum CardType
{
	SPADE, CLUB, DIAMOND, HEART
}

enum CardValue
{
	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, KNAVE, QUEEN, KING, ACE
}

