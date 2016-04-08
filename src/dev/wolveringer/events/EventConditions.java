package dev.wolveringer.events;

import java.util.UUID;

import dev.wolveringer.client.connection.ClientType;
import dev.wolveringer.dataserver.gamestats.GameType;
import dev.wolveringer.dataserver.gamestats.StatsKey;
import dev.wolveringer.dataserver.protocoll.DataBuffer;

public enum EventConditions {
	PLAYERS_BACKLIST {
		@Override
		public EventCondition createCondition() {
			return new ChangeableEventCondition<UUID>(getConditionType()) {
				@Override
				public UUID readElement(DataBuffer buffer) {
					return buffer.readUUID();
				}

				@Override
				public void writeElement(UUID obj, DataBuffer buffer) {
					buffer.writeUUID(obj);
				}

				@Override
				public EventConditions getCondition() {
					return PLAYERS_BACKLIST;
				}
			};
		}

		@Override
		public Class<UUID> getConditionType() {
			return UUID.class;
		}
	},
	PLAYERS_WHITELIST {
		@Override
		public EventCondition createCondition() {
			return new ChangeableEventCondition<UUID>(getConditionType()) {
				@Override
				public UUID readElement(DataBuffer buffer) {
					return buffer.readUUID();
				}

				@Override
				public void writeElement(UUID obj, DataBuffer buffer) {
					buffer.writeUUID(obj);
				}

				@Override
				public EventConditions getCondition() {
					return PLAYERS_WHITELIST;
				}
			};
		}

		@Override
		public Class<UUID> getConditionType() {
			return UUID.class;
		}
	},
	GAME_TYPE_ARRAY {
		@Override
		public EventCondition createCondition() {
			return new ChangeableEventCondition<GameType>(getConditionType()) {
				@Override
				public GameType readElement(DataBuffer buffer) {
					return GameType.values()[buffer.readInt()];
				}

				@Override
				public void writeElement(GameType obj, DataBuffer buffer) {
					buffer.writeInt(obj.ordinal());
				}

				@Override
				public EventConditions getCondition() {
					return GAME_TYPE_ARRAY;
				}
			};
		}

		@Override
		public Class<GameType> getConditionType() {
			return GameType.class;
		}
	},
	CLIENT_TYPE_ARRAY {
		@Override
		public EventCondition createCondition() {
			return new ChangeableEventCondition<ClientType>(getConditionType()) {
				@Override
				public ClientType readElement(DataBuffer buffer) {
					return ClientType.values()[buffer.readInt()];
				}

				@Override
				public void writeElement(ClientType obj, DataBuffer buffer) {
					buffer.writeInt(obj.ordinal());
				}

				@Override
				public EventConditions getCondition() {
					return CLIENT_TYPE_ARRAY;
				}
			};
		}

		@Override
		public Class<ClientType> getConditionType() {
			return ClientType.class;
		}
	},
	SERVER_NAME_ARRAY {
		@Override
		public EventCondition createCondition() {
			return new ChangeableEventCondition<String>(getConditionType()) {
				@Override
				public String readElement(DataBuffer buffer) {
					return buffer.readString();
				}

				@Override
				public void writeElement(String obj, DataBuffer buffer) {
					buffer.writeString(obj);
				}

				@Override
				public EventConditions getCondition() {
					return SERVER_NAME_ARRAY;
				}
			};
		}

		@Override
		public Class<String> getConditionType() {
			return String.class;
		}
	},
	SETTING_ARRAY {
		@Override
		public EventCondition createCondition() {
			return new ChangeableEventCondition<StatsKey>(getConditionType()) {
				@Override
				public StatsKey readElement(DataBuffer buffer) {
					return StatsKey.values()[buffer.readInt()];
				}

				@Override
				public void writeElement(StatsKey obj, DataBuffer buffer) {
					buffer.writeInt(obj.ordinal());
				}

				@Override
				public EventConditions getCondition() {
					return SETTING_ARRAY;
				}
			};
		}

		@Override
		public Class<StatsKey> getConditionType() {
			return StatsKey.class;
		}
	};
	
	public abstract EventCondition createCondition();
	public abstract Class<?> getConditionType();
	
	public static EventCondition readCondition(DataBuffer buffer){
		EventConditions con = values()[buffer.readInt()];
		EventCondition contition = con.createCondition();
		((SerelizeableEventCondition)contition).read(buffer);
		return contition;
	}
	public static DataBuffer writeCondition(EventCondition con,DataBuffer buffer){
		buffer.writeInt(con.getCondition().ordinal());
		((SerelizeableEventCondition)con).write(buffer);
		return buffer;
	}
}
