import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  encapsulation: ViewEncapsulation.Emulated
})
export class AdminComponent implements OnInit {

  constructor() { }

  ngOnInit() {  
    this.loadJsFile("assets/admin/js/jquery-3.2.1.min.js");
    this.loadJsFile("assets/admin/js/popper.min.js");
    this.loadJsFile("assets/admin/js/bootstrap.min.js");
    this.loadJsFile("assets/admin/plugins/slimscroll/jquery.slimscroll.min.js");
    this.loadJsFile("assets/admin/plugins/raphael/raphael.min.js");
    this.loadJsFile("assets/admin/plugins/morris/morris.min.js");
    this.loadJsFile("assets/admin/js/chart.morris.js");
    this.loadJsFile("assets/admin/js/script.js");
  }  

  public loadJsFile(url) {  
    let node = document.createElement('script');  
    node.src = url;  
    node.type = 'text/javascript';  
    document.getElementsByTagName('head')[0].appendChild(node);  
  }  

}
