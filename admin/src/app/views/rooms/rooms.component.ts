import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {RoomsService} from '../../services/rooms.service';
// import {Customer} from "../../dtos/customer";
import {Rooms} from '../../dtos/rooms';
import {NgForm} from '@angular/forms';
// import {PlaceOrderServiceService} from "../../services/place-order-service.service";

@Component({
  selector: 'app-items',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css']
})
export class RoomsComponent implements OnInit {
  manuallySelected: false;
  selectedrooms: Rooms = new Rooms() ;
  roomList: Array<Rooms> = [];
  roomCode = 0;
  tempRoom: Rooms = new Rooms();
  selectedImage: File = null;

  @ViewChild('frmrooms') frmrooms: NgForm;
  constructor(private roomService: RoomsService, private elem: ElementRef) { }

  ngOnInit() {
    // this.elem.nativeElement.querySelector('#roomSearchID').value;
    this.getAllIRooms();
    this.getTotalRooms();
  }
  onFile(event): void {
    this.selectedImage = <File> event.target.files[0];
  }
  saverooms(): void {
    // const fd = new FormData();
    // fd.append('image', this.selectedImage, this.selectedImage.name);
    // console.log(fd);
    // this.selectedrooms.image = fd;
    this.selectedrooms.id = this.elem.nativeElement.querySelector('#roomID').value;
    this.roomService.saveRooms(this.selectedrooms).subscribe(
      (result) => {
        if (result) {
          alert('New Room Added Successfuly');
          this.getAllIRooms();
          this.getTotalRooms();
          this.clear();
        } else {
          alert('New Room Added Failed !');
        }
      }
    );
  }
  selectrooms(rooms): void {
    this.clear();
    this.getAllIRooms();
    this.selectedrooms = rooms;
  }
  DesableRoom(id): void {

  }
  getAllIRooms(): void {
    this.roomService.getAllIRooms().subscribe(
  (result) => {
    this.roomList = result;
     }
    );
  }

  getTotalRooms(): void {
    this.roomService.getTotalRooms().subscribe(
      (value) => {
        this.roomCode = value + 1;
      }
    );
  }

  clear(): void {
    const a = this.elem.nativeElement.querySelector('#roomID').value;
    const index = this.roomList.indexOf(this.selectedrooms);

    if (index !== -1) {
      this.roomList[index] = this.tempRoom;
      this.tempRoom = null;
    }
    this.selectedrooms = new Rooms;
    this.manuallySelected = false;
     this.getTotalRooms();
    this.selectedrooms.id = '' + this.roomCode;
    this.elem.nativeElement.querySelector('#roomSearchID').value = null;
  }
  update(e): void {}

  searchCustomer(): void {
    const a = this.elem.nativeElement.querySelector('#roomSearchID').value;
    // this.elem.nativeElement.q
    // const myContainer = document.getElementById('roomType') as HTMLInputElement;
    // myContainer.innerHTML = '<input type="text">';
    this.roomService.searchRoom(a).subscribe(
      (value) => {
        this.selectedrooms = value;
      }
    );
    const element = <HTMLInputElement> this.elem.nativeElement.querySelector('#roomType').html;
    console.log(element);
  }
}
