import {Rooms} from './rooms';

export class ReserveRooms {
  id;
  roomDto: Rooms = new Rooms();
  checkInDate;
  checkOutDate;
  user = '';
  status = '';
}
