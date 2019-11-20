import { Component, OnInit } from '@angular/core';
import { Vender } from '../vender';
import { VendorService } from '../services/vendor.service';
import { Router, ActivatedRoute } from '@angular/router';
import { VendorCrudsService } from '../services/vendor-cruds.service';

@Component({
  selector: 'app-add-vender',
  templateUrl: './add-vender.component.html',
  styleUrls: ['./add-vender.component.scss']
})
export class AddVenderComponent implements OnInit {

  vender=new Vender();
  venders:Vender[];
  
  constructor(private route : ActivatedRoute, private router:Router , private vendorCrudsService : VendorCrudsService ) { }

  ngOnInit() {
    this.route.params.subscribe(params => this.getVenderById(params['venderId']));
  }

  saveVendors(): void{
      this.vendorCrudsService.saveVenders(this.vender)
      .subscribe((response)=>{
          console.log(response); 
          this.router.navigate(['/viewVender'])
        }, (error)=>{
          console.log(error);
          
        }); 
    }

    editVender():void{
      this.vendorCrudsService.saveVenders(this.vender).subscribe((response)=>{
        console.log(response);
        this.router.navigate(['/viewVender']);
      },(error)=>{
        console.log(error);
      });
      
      }


    getVenderById(venderId:number){
      console.log(venderId);
      this.vendorCrudsService.getVenderById(venderId)
      .subscribe((editData) =>{
        this.vender=editData;
        console.log(editData);
      }, (error) =>{
      console.log(error);
    });
      }
    

Back()
{
  this.router.navigate(['/back']);
}
}
