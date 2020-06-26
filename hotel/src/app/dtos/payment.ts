import {ReserveRooms} from './reserve';

export class Payment {
  id = 0;
  date;
  reservationDto: ReserveRooms = new ReserveRooms;
  fee;
  status;
}
