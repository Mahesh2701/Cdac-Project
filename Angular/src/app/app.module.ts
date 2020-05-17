import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import {HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { HomepageComponent } from './homepage/homepage.component';
import { HomeComponent } from './home/home.component';
import { HimageComponent } from './himage/himage.component';
import { PostComponent } from './post/post.component';
import { ProblemformComponent } from './problemform/problemform.component';
import { VillagePostsComponent } from './village-posts/village-posts.component';
import { UpdateprofileComponent } from './updateprofile/updateprofile.component';
import { CommentComponent } from './comment/comment.component';
import { NotificationComponent } from './notification/notification.component';



@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    HomepageComponent,
    HomeComponent,
    HimageComponent,
    PostComponent,
    ProblemformComponent,
    VillagePostsComponent,
    UpdateprofileComponent,
    CommentComponent,
    NotificationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
    ,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
