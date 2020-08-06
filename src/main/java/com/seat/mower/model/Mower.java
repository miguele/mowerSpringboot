package com.seat.mower.model;

import com.seat.mower.constant.CardinalPoints;
import com.seat.mower.constant.MovementMower;

/**
 * Object class Mower
 * 
 * @author miguel
 *
 */
public class Mower {

	private final static String BLANK = " ";

	private int x = 0;
	private int y = 0;
	private char directtion;

	public Mower(int x, int y, char directtion) {
		this.x = x;
		this.y = y;
		this.directtion = directtion;
	}

	public Mower() {
		super();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getDirecttion() {
		return directtion;
	}

	public void setDirecttion(char directtion) {
		this.directtion = directtion;
	}

	public void move(char[] moveArray) {
		for (char moveChar : moveArray) {
			moveStep(moveChar);
		}
	}

	private void moveStep(char movementkey) {

		switch (movementkey) {
		case MovementMower.TURN_LEFT:
			getDirection(movementkey);
			break;
		case MovementMower.TURN_RIGHT:
			getDirection(movementkey);
			break;
		case MovementMower.MOVE_FORWARD:
			moveForward();
			break;
		}

	}

	private void moveForward() {
		switch (directtion) {
		case CardinalPoints.NORTH:
			y = y + 1;
			break;
		case CardinalPoints.EAST:
			x = x + 1;
			break;
		case CardinalPoints.SOUTH:
			y = y - 1;
			break;
		case CardinalPoints.WEST:
			x = x - 1;
			break;
		}
	}

	private void getDirection(char directtionVal) {
		switch (directtionVal) {
		case MovementMower.TURN_LEFT:
			turnLeft(directtionVal);
			break;
		case MovementMower.TURN_RIGHT:
			turnRight(directtionVal);
			break;
		}
	}

	private void turnRight(char directtionVal) {
		switch (directtion) {
		case CardinalPoints.NORTH:
			directtion = CardinalPoints.EAST;
			break;
		case CardinalPoints.EAST:
			directtion = CardinalPoints.SOUTH;
			break;
		case CardinalPoints.SOUTH:
			directtion = CardinalPoints.WEST;
			break;
		case CardinalPoints.WEST:
			directtion = CardinalPoints.NORTH;
			break;
		}
	}

	private void turnLeft(char directtionVal) {
		switch (directtion) {
		case CardinalPoints.NORTH:
			directtion = CardinalPoints.WEST;
			break;
		case CardinalPoints.EAST:
			directtion = CardinalPoints.NORTH;
			break;
		case CardinalPoints.SOUTH:
			directtion = CardinalPoints.EAST;
			break;
		case CardinalPoints.WEST:
			directtion = CardinalPoints.SOUTH;
			break;
		}
	}

	@Override
	public String toString() {
		return x + BLANK + y + BLANK + directtion;
	}

}
