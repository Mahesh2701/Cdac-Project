import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { PostComponent } from './post/post.component';
import { HomeComponent } from './home/home.component';
import { ProblemformComponent } from './problemform/problemform.component';
import { HomepageComponent } from './homepage/homepage.component';
import { VillagePostsComponent } from './village-posts/village-posts.component';
import { UpdateprofileComponent } from './updateprofile/updateprofile.component';
import { CommentComponent } from './comment/comment.component';
import { NotificationComponent } from './notification/notification.component';


const routes: Routes = 
[{path:'villagepost',component:VillagePostsComponent},
{path:'',component:LoginComponent},
{path:'registration',component:RegistrationComponent},
{path:'post',component:PostComponent},
{path:'problemform',component:ProblemformComponent},
{path:'homepage',component:HomepageComponent},
{path:'updateprofile',component:UpdateprofileComponent},
{path:'comment',component:CommentComponent},
{path:'notification',component:NotificationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
