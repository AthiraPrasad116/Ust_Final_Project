import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Vender } from '../vender';
import { VendorService } from '../services/vendor.service';

@Component({
  selector: 'app-view-vender',
  templateUrl: './view-vender.component.html',
  styleUrls: ['./view-vender.component.scss']
})
export class ViewVenderComponent implements OnInit {

  vender=new Vender();
  venders:Vender[];
  searchString:string;

  constructor(private rout : ActivatedRoute , private router:Router , private vendorService : VendorService) { }

  ngOnInit() {
    this.getVendorDetails();
    
  }

  getVendorDetails():void{
    this.vendorService.getAllVendorDetails()
    .subscribe((venderData) =>{
      this.venders=venderData,
      console.log(venderData);
    }, (error) =>{
      console.log(error);
    });
    }


addVender(){
  this.router.navigate(['addVender']);
}

editVender(venderId : number){
  this.router.navigate(['editVender/'+ venderId]);
  
}

Logout()
{
  this.router.navigate(['/Logout']);
}


disableVender(venderId:number):void{    
  this.vendorService.disableVender(venderId)
  .subscribe((data)=>{
    this.getVendorDetails();
    console.log(data)
  }, (error)=>{
    console.log(error)
  
  });
    
 } 
 
 SearchVendor(searchString : string): void{

  if(searchString!=null)
  {
    this.vendorService.searchVendor(searchString).subscribe((vendorData)=>{
      this.searchString=undefined;
      this.venders=vendorData,
      console.log(vendorData);

    },(error)=>{
      console.log(error);
    });
  }
  else{ 
    this.getVendorDetails();
  }
}

}
