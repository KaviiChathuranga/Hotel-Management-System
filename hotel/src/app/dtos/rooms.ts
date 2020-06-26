import {Facilities} from './facilities';

export class Rooms {

  id: string ;
  name: string;
  reserveType: string;
  type: string;
  description: string;
  price: number;
  facilities: Array<Facilities>;
}
