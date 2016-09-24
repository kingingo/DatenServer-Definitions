package dev.wolveringer.events.gilde;

import java.util.UUID;

import dev.wolveringer.dataserver.protocoll.DataBuffer;
import dev.wolveringer.events.Event;
import dev.wolveringer.events.EventType;
import dev.wolveringer.gilde.GildeType;
import dev.wolveringer.gilde.MoneyLogRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GildeMoneyChangeEvent extends Event{
	public static enum Action {
		ADD,
		REMOVE,
		SET,
		HISTORY_ADD;
	}
	private UUID gilde;
	private GildeType gildenType;
	private Action action;
	
	private int money;
	
	private MoneyLogRecord record;
	
	@Override
	public void read(DataBuffer buff) {
		gilde = buff.readUUID();
		gildenType = buff.readEnum(GildeType.class);
		action = buff.readEnum(Action.class);
		switch (action) {
		case ADD:
		case REMOVE:
		case SET:
			money = buff.readInt();
			break;
		case HISTORY_ADD:
			record = new MoneyLogRecord(buff.readLong(), buff.readInt(), buff.readInt(), buff.readString());
			break;
		default:
			break;
		}
	}

	@Override
	public void write(DataBuffer buff) {
		buff.writeUUID(gilde);
		buff.writeEnum(gildenType);
		buff.writeEnum(action);
		switch (action) {
		case ADD:
		case REMOVE:
		case SET:
			buff.writeInt(money);
			break;
		case HISTORY_ADD:
			buff.writeLong(record.getDate());
			buff.writeInt(record.getPlayerId());
			buff.writeInt(record.getAmount());
			buff.writeString(record.getMessage());
			break;
		default:
			break;
		}
	}

	@Override
	public EventType getType() {
		return EventType.GILDE_MONEY_UPDATE;
	}
	
}
